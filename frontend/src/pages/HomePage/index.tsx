import ProductService from "@/service/ProductService"; 
import { ProductCard } from "@/components/CardsProducts";
import { IProductCard } from "@/commons/interfaces";
import { useEffect, useState } from "react";
import { NavBar } from "@/components/NavBar";

export function HomePage() {
    const [data, setData] = useState<IProductCard[]>([]);
    const [apiError, setApiError] = useState("");
    const [selectedCategory, setSelectedCategory] = useState("all");

    useEffect(() => {
        loadData();
    }, []);

    const loadData = async () => {
        try {
            const response = await ProductService.findAll();
            if (response.status === 200) {
                setData(response.data);
            } else {
                setApiError("Falha ao carregar a lista de produtos!");
            }
        } catch (error) {
            setApiError("Erro ao buscar produtos.");
        }
    };

    const adicionarAoCarrinho = (id: number) => {
        const carrinho = JSON.parse(localStorage.getItem("carrinho") || "[]");

        if (!Array.isArray(carrinho)) {
            localStorage.setItem("carrinho", JSON.stringify([]));
        }

        const produtoSelecionado = data.find((prod) => prod.id === id);
        if (produtoSelecionado) {
            const produtoNoCarrinho = carrinho.find((item) => item.id === id);
            if (!produtoNoCarrinho) {
                carrinho.push({ ...produtoSelecionado, quant: 1 });
                localStorage.setItem("carrinho", JSON.stringify(carrinho));
                alert("Produto adicionado ao carrinho.");
            } else {
                alert("Produto já está no carrinho.");
            }
        } else {
            alert("Produto não encontrado.");
        }
    };

    // Supondo que cada produto possua a propriedade "category" do tipo { id: number, name: string }
    const categories = ["all", ...new Set(data.map(prod => prod.category.name))];

    const filteredData = selectedCategory === "all" 
        ? data 
        : data.filter(prod => prod.category.name === selectedCategory);

    return (
        <>
            <NavBar />
            <main className="container">
                <section className="py-5 bg-light">
                    <div className="container text-center">
                        <h2 className="mb-4">Escolha seus Produtos</h2>
                        {apiError && <p className="text-danger">{apiError}</p>}
                        
                        <div className="mb-4">
                            <label htmlFor="category-select" className="me-2">Filtrar por categoria:</label>
                            <select 
                                id="category-select" 
                                value={selectedCategory} 
                                onChange={(e) => setSelectedCategory(e.target.value)}
                            >
                                {categories.map((cat, index) => (
                                    <option key={index} value={cat}>
                                        {cat === "all" ? "Todas as Categorias" : cat}
                                    </option>
                                ))}
                            </select>
                        </div>
                        
                        <div id="cards" className="row card-container">
                            {filteredData.map((prodCard) => (
                                <ProductCard
                                    key={prodCard.id}
                                    id={prodCard.id}
                                    imageUrl={prodCard?.img || "https://placehold.co/200x300"}
                                    name={prodCard.name}
                                    price={prodCard.price}
                                    onAddToCart={() => adicionarAoCarrinho(prodCard.id)}
                                />
                            ))}
                        </div>
                    </div>
                </section>
            </main>
        </>
    );
}
