import styled from 'styled-components';

function LoginPage() {
  return <StyledContainer>나는 로그인 화면</StyledContainer>;
}

const StyledContainer = styled.div`
  background-color: ivory;
  width: 50vw;
  height: 100vh;
  margin: auto;
  display: flex;
  justify-content: center;
  align-items: center;
`;

export default LoginPage;
