import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';

function MainPage() {
  interface IUserInfo {
    nickname: string;
    profileImg: string;
    username: string;
    email: string;
  }

  const [userData, setUserData] = useState<IUserInfo | null>(null);
  const navigate = useNavigate();

  const getLoginData = async () => {
    try {
      /**
       * @todo : 배포 주소로 변경
       */
      const res = await axios.post('http://localhost:8080/api/member', null, {
        withCredentials: true,
        headers: {
          'Content-Type': 'application/json',
        },
      });

      return res.data;
    } catch (e) {
      // 에러 발생 시 시작화면으로 이동
      navigate('/start');
    }

    return null;
  };

  const checkLocalStorage = async () => {
    if (!localStorage.getItem('VC_nickname')) {
      const data = await getLoginData();
      setUserData({
        ...userData,
        nickname: data.nickname,
        profileImg: data.profileImg,
        username: data.username,
        email: data.email,
      });
    }
  };

  useEffect(() => {
    checkLocalStorage();
  }, []);

  return <div>메인페이지</div>;
}

export default MainPage;
