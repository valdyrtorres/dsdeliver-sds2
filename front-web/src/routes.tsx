import { BrowserRouter, Switch, Route } from "react-router-dom";
import Orders from "./orders";
import Home from "./home";
import Navbar from "./navbar";

function Routes() {
    return (
        <BrowserRouter>
            <Navbar />
            <Switch>
                <Route path="/orders">
                    <Orders />
                </Route>
                <Route path="/">
                    <Home />
                </Route>                
            </Switch>
        </BrowserRouter>
    )
}

export default Routes;