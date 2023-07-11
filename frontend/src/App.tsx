import { BrowserRouter, Route, Routes } from 'react-router-dom';
import Start from 'pages/StartPage';
import Main from 'pages/MainPage';

function App() {
  return (
    <div className="App">
      <BrowserRouter>
        <Routes>
          <Route path="/start" element={<Start />} />
          <Route path="/" element={<Main />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
