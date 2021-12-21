import logo from "./logo.svg";
import "./App.css";
import { useState } from "react";

function App() {
  const [task, setTask] = useState("");
  const [tasks, setTasks] = useState(["Learn React", "Learn Vue"]);

  const onSummit = (e) => {
    e.preventDefault();

  };


  return (
    <div className="App">
      <header className="App-header">
        <h1>Todo app </h1>
      </header>
      <main>
        <form>
          <input type="text" name="task" placeholder="Hello" onChange={(e) => {
            setTask(e.target.value);
          }} />
          <button onClick={onSummit}>Add</button>
        </form>

        <ul>
          {
            tasks.map((task, index) => {
              return <li key={index}>{task}</li>
            }
            )
          }
        </ul>

      </main>
    </div>
  );
}

export default App;
