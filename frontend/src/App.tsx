import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Start from 'pages/StartPage';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/" element={<Start />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
