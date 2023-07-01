import styled from 'styled-components';
import LogoSrc from '../assets/VC_logo.png';
import GithubLogoSrc from '../assets/VC_github_img.png';

function StartPage() {
  return (
    <StyledLoginPage>
      <Container>
        <LogoImg src={LogoSrc} width={50} margin="0 0 20px 0" />
        <LogoText fontSize={18} color="white" border={400}>
          실시간 소통 및 에디터 서비스
        </LogoText>
        <LogoText fontSize={60} color="white" border={800}>
          View<span>Code</span>
        </LogoText>
        <TempBox height={30} />
        <LogoText fontSize={15} color="white" border={300}>
          계정이 없으신가요?
        </LogoText>
        <LoginButton>
          <LogoImg src={GithubLogoSrc} width={30} margin="0 10px 0 0" />
          <LogoText fontSize={20} color="rgb(256, 256, 256, 0.8)" border={300}>
            Continue with Github
          </LogoText>
        </LoginButton>
      </Container>
    </StyledLoginPage>
  );
}

const StyledLoginPage = styled.div`
  background-color: #12161d;
`;

const Container = styled.div`
  width: 50vw;
  height: 100vh;
  margin: auto;
  display: flex;
  justify-content: center;
  align-items: center;
  flex-direction: column;
`;

interface IImg {
  width: number;
  margin: string;
}

const LogoImg = styled.img<IImg>`
  width: ${(props) => props.width}px;
  margin: ${(props) => props.margin};
`;

interface ILogoText {
  fontSize: number;
  color: string;
  border: number;
}

const LogoText = styled.div<ILogoText>`
  font-size: ${(props) => props.fontSize}px;
  color: ${(props) => props.color};
  font-weight: ${(props) => props.border};

  span {
    color: #75bdff;
  }
`;

interface ITempBox {
  height: number;
}

const TempBox = styled.div<ITempBox>`
  width: 100%;
  height: ${(props) => props.height}px;
`;

const LoginButton = styled.button`
  width: 300px;
  height: 60px;
  margin-top: 20px;
  display: flex;
  justify-content: center;
  align-items: center;
  background-color: #12161d;
  outline: none;
  border-radius: 10px;
  border: 3px solid rgba(255, 255, 255, 0.2);
  transition: 0.5s all linear;

  &:hover {
    background-color: rgba(255, 255, 255, 0.2);
    cursor: pointer;
  }
`;

export default StartPage;
