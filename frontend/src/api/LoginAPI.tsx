import axios from 'axios';

export const LoginAPI = {
  async getUserInfo() {
    /**
     * @todo: 배포 주소로 변경
     */
    const res = await axios.post('http://localhost:8080/api/member', null, {
      withCredentials: true,
      headers: {
        'Content-Type': 'application/json',
      },
    });

    return res.data;
  },
};
