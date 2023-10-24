import './App.css';
import "../node_modules/bootstrap/dist/css/bootstrap.min.css";
import Navbar from './Layout/Navbar';
import Home from './Pages/Home';
import {BrowserRouter as Router, Routes, Route} from "react-router-dom";
import AddUser from './Users/AddUser';
import EditUser from './Users/EditUser';
import ViewUser from './Users/ViewUser';

function App() {
  return <div className="App">
    <Router>
      <Navbar/>
      
      <Routes>
        <Route exact path="/" element={<Home/>} />
        <Route exact path="/addUser" element={<AddUser/>} />
        <Route exact path="/editUser/:id" element={<EditUser/>} />
        <Route exact path="/viewUser/:id" element={<ViewUser/>} />
      </Routes>
    </Router>
  </div>;
}

export default App;
