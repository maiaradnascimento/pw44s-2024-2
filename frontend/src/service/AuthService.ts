import {api} from "@/lib/axios"
import { IUserSignup } from "@/commons/interfaces";
import { IUserLogin } from "@/commons/interfaces";
import { IUser } from "@/commons/interfaces";

const signup = async(user: IUserSignup) =>{
    let response;
    try{
        response = await api.post("/users", user)
    }catch(error: any){
        response = error.response
    }
    return response;
    
};

const login = async (user: IUserLogin) =>{
    let response;
    try{
        response = await api.post("/login", user);
        localStorage.setItem("token", JSON.stringify(response.data.token));
        api.defaults.headers.common["Authorization"] =  `Bearer ${response.data.token}`;
    }catch(error: any){
        response = error.response;
    }
    return response
}

const isAuthenticaded = () : boolean =>{
    const token = localStorage.getItem("token");

    if(token){
        api.defaults.headers.common["Authorization"] =  `Bearer ${JSON.parse(token)}`;
    }

    return token ? true : false;
}

const getUser = async() =>{
    const username = localStorage.getItem("username");
    let response;
    try{
        response = await api.get(`/users/${JSON.parse(username)}`)
        localStorage.setItem("userId", JSON.stringify(response.data.id));
    }catch(error: any){
        response = error.response;
    }
    return response;
}

const logout = () =>{
    localStorage.removeItem("token");
    localStorage.removeItem("username");
    localStorage.removeItem("userId");
    api.defaults.headers.common["Authorization"] = "";
}

const AuthService = {
    signup,
    login,
    isAuthenticaded,
    logout,
    getUser,
}

export default AuthService;