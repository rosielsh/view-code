import { LoginAPI } from 'api/LoginAPI';

const LoginUtil = {
  isNotLogined() {
    if (!localStorage.getItem('VC_nickname')) return true;
    return false;
  },

  async getUserInfo() {
    const res = await LoginAPI.getUserInfo();
    return res;
  },
};

export default LoginUtil;
