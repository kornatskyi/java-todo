import axios from 'axios';

const API_URL = 'http://localhost:8080';

export const getTodos = () => {
    return axios.get(API_URL + '/todos').then(res => res.data);
}


export const createTodo = (todo) => {
    return axios.post(API_URL + '/todo/add', {
        body: todo,

    }).then(res => res.data);
}
