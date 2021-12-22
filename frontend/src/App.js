import "./App.css";
import { useEffect, useRef, useState } from "react";
import { HiOutlineTrash } from "react-icons/hi";
import { AiOutlineEdit } from "react-icons/ai";
import { createTodo, getTodos } from "./apiCalls";

class Task {
  constructor(text = "new task", done = false, date = null) {
    this.text = text;
    this.done = false;
    this.date = {};
  }
}

function App() {
  const [task, setTask] = useState(new Task());
  const [tasks, setTasks] = useState([]);
  const input = useRef(null);

  const onSummit = async (e) => {
    e.preventDefault();

    const createdTodo = await createTodo(task);
    console.log(createdTodo);
    setTasks([...tasks, createdTodo]);
    input.current.value = "";
  };

  const handleDone = (task) => {
    setTask(new Task(task.text, !task.done, task.date));
    task.done = !task.done;
  };

  useEffect(() => {
    (async () => {
      const todos = await getTodos();
      console.log(todos);
      setTasks(todos);
    })();
  }, []);

  return (
    <div className="App">
      <header className="App-header">
        <h1>Todo app </h1>
      </header>
      <main>
        <div className="flex justify-center mt-7">
          <input
            ref={input}
            className="text-gray-600 pl-1 rounded-sm"
            type="text"
            name="task"
            placeholder="Write your task here"
            onChange={(e) => {
              setTask(new Task(e.target.value));
            }}
          />
          <button
            className="bg-gray-800 hover:bg-gray-900 text-white font-bold py-2 px-4 rounded mx-3"
            onClick={onSummit}
          >
            Add
          </button>
        </div>

        <div className="flex flex-col items-center mt-5">
          {tasks.map((task, index) => {
            return (
              <div
                className="flex items-center w-1/3 justify-between"
                key={index}
              >
                <AiOutlineEdit className=" mr-2 hover:text-blue-500 cursor-pointer" />
                <span className="flex flex-col">
                  <span
                    className={
                      task.done
                        ? "line-through cursor-pointer hover:scale-110 text-green-500"
                        : "cursor-pointer hover:scale-110  text-orange-500"
                    }
                    onClick={() => {
                      handleDone(task);
                    }}
                  >
                    {task.text}
                  </span>
                  <span className="text-xs">{task.date}</span>
                </span>
                <HiOutlineTrash className="ml-2 hover:text-red-500 cursor-pointer" />
              </div>
            );
          })}
        </div>
      </main>
    </div>
  );
}

export default App;
