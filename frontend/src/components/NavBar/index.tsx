import AuthService from "@/service/AuthService";
import { Link, NavLink, useNavigate } from "react-router-dom";
import logo from "@/assets/utfpr-logo.png";

export function NavBar() {
    const navigate = useNavigate();
    const isLoggedIn = AuthService.isAuthenticaded();

    const onClickAuth = () => {
        if (isLoggedIn) {
            AuthService.logout();
            navigate("/login");
        } else {
            navigate("/login");
        }
    };

    const routes = [
        { path: "/", label: "Home" },
        { path: "/cart", label: "Carrinho" },
        { path: "/order", label: "Pedidos" },
    ];

    return (
        <div className="bg-white shadow-sm mb-2">
            <div className="container">
                <nav className="navbar navbar-light navbar-expand">
                    <Link to="/" className="navbar-brand">
                        <img src={logo} width="60" alt="UTFPR" />
                    </Link>
                    <ul className="navbar-nav me-auto mb-2 mb-md-0">
                        {routes.map(({ path, label }) => (
                            <li className="nav-item" key={path}>
                                <NavLink
                                    to={path}
                                    className={({ isActive }) =>
                                        isActive ? "nav-link active" : "nav-link"
                                    }
                                >
                                    {label}
                                </NavLink>
                            </li>
                        ))}
                        <li className="nav-item">
                            <button className="btn btn-light" onClick={onClickAuth}>
                                {isLoggedIn ? "× Sair" : "Entrar"}
                            </button>
                        </li>
                    </ul>
                </nav>
            </div>
        </div>
    );
}
