import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";
import { HiOutlineTrash } from 'react-icons/hi'
import { AiOutlineEdit } from 'react-icons/ai'

function App() {
  const [task, setTask] = useState("");
  const [tasks, setTasks] = useState([]);

  const onSummit = (e) => {
    e.preventDefault();

    console.log("hello");
    console.log(tasks);
    setTasks([...tasks, task]);

  };


  return (
    <div className="App">
      <header className="App-header">
        <h1>Todo app </h1>
      </header>
      <main>
        <div className="flex justify-center mt-7">
          <input className="text-gray-600 pl-1 rounded-sm" type="text" name="task" placeholder="Hello" onChange={(e) => {
            console.log(task);
            setTask(e.target.value);
          }} />
          <button className="bg-gray-800 hover:bg-gray-900 text-white font-bold py-2 px-4 rounded mx-3" onClick={onSummit}>Add</button>
        </div>

        <div className="flex flex-col items-center mt-5">
          {
            tasks.map((task, index) => {
              return (<div className="flex items-center w-1/3 justify-between" key={index}> <AiOutlineEdit className="mr-2 hover:text-blue-500 cursor-pointer" /> <span>{task}</span>  <HiOutlineTrash className="ml-2 hover:text-red-500 cursor-pointer" /></div>)
            }
            )
          }
        </div>

      </main>
    </div>
  );
}

export default App;
