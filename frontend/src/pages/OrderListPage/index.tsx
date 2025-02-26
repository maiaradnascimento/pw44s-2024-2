import OrderService from "@/service/OrderService";
import { useEffect, useState } from "react";
import { Link } from "react-router-dom";
import { IOrder } from "src/commons/interfaces";
import { NavBar } from "@/components/NavBar";

export function OrderListPage() {
    const [data, setData] = useState<IOrder[]>([]);
    const [apiError, setApiError] = useState("");

    useEffect(() => {
        loadData();
    }, []);

    const loadData = async () => {
        try {
            const usernameId = localStorage.getItem("userId");
            const response = await OrderService.findAllByUser(usernameId);
            if (response.status === 200) {
                console.log(response.data);
                setData(response.data);
            } else {
                setApiError("Falha ao carregar a lista de pedidos!");
            }
        } catch (error) {
            setApiError("Erro ao buscar pedidos.");
        }
    };

    return (
        <>  
            <NavBar />
            <main className="container">
                <div className="text-center">
                    <span className="h3- mb-3 fw-normal">Meus Pedidos</span>
                </div>

                <table className="table table-striped">
                    <thead>
                        <tr>
                            <th>#</th>
                            <th>Data</th>
                            <th>Total</th>
                            <th>Status</th>
                            <th>Detalhes</th>
                        </tr>
                    </thead>
                    <tbody>
                        {data.map((order: IOrder) => (
                            <tr key={order.id}>
                                <td>{order.id}</td>
                                <td>{new Date(order.date).toLocaleDateString()}</td>
                                <td>R$ {order.price}</td>
                                <td>Finalizada</td>
                                <td>
                                    <Link to={`/orders/${order.id}`} className="btn btn-info">Ver Detalhes</Link>
                                </td>
                            </tr>
                        ))}
                    </tbody>
                </table>
                {apiError && (
                    <div className="alert alert-danger">{apiError}</div>
                )}
            </main>
        </>
    );
}
