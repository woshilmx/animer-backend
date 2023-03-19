import axios from "axios";


const myaxios = axios.create({
    baseURL: 'http://127.0.0.1/api/',
    timeout: 1000,
    // headers: {'X-Custom-Header': 'foobar'}
});


export default myaxios;