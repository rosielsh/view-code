import React, { useState, useEffect } from 'react';
import { useNavigate } from 'react-router-dom';

import LoginUtil from 'utils/LoginUtil';
import { IUserInfo } from 'types/userInfo';

function MainPage() {
  const [userData, setUserData] = useState<IUserInfo | null>(null);
  const navigate = useNavigate();

  const checkIsLogined = async () => {
    if (LoginUtil.isNotLogined()) {
      try {
        const data = await LoginUtil.getUserInfo();
        setUserData({
          ...userData,
          nickname: data.nickname,
          profileImg: data.profileImg,
          username: data.username,
          email: data.email,
        });
      } catch (e) {
        // 에러 발생 시 시작화면으로 이동
        navigate('/start');
      }
    }
  };

  useEffect(() => {
    checkIsLogined();
  }, []);

  return <div>메인페이지</div>;
}

export default MainPage;
