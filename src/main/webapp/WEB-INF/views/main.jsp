<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!doctype html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>송민건님의 사이트입니다.</title>
    <link rel="stylesheet" href="/assets/css/reset.css">
    <link rel="stylesheet" href="/assets/css/main.css">
</head>
<body>
    <%@ include file="pageinfo/header.jsp"%>
    <div id="main-div">
        <h1>안녕하세요!</h1>
        <hr />
            <h2>기술스택</h2>
        <div id="stack-list">
            <span>HTML</span>
            <span>CSS</span>
            <span>Javascript</span>
            <span>Java</span>
            <span>Jsp</span>
            <span>MyBatis</span>
            <span>JPA</span>
            <span>Spring</span>
            <span>SQL</span>
        </div>
        <hr />
        <h2>자격증</h2>
        <div id="license-list">
            <div class="license">
                <span>정보처리기능사</span>
            </div>
            <div class="license">
                <span>정보처리산업기사</span>
            </div>
        </div>
        <hr />
        <h2>진행한 프로젝트</h2>
        <div id="project-list">
            <div class="project">
                <span>KITPA(한국정보기술진흥원) 2회 대회 시스템 개발</span>
                <span>2024.01.21 ~ 2024.03.16</span>
            </div>
            <div class="project">
                <span>나의 소개 웹페이지</span>
                <span>2024.06.18 ~ now</span>
            </div>
        </div>
    </div>
    <%@ include file="pageinfo/footer.jsp"%>
</body>
<script>
    const techStackURL = 'api/v1/tech'

    //서버에 저장된 TechStack을 가져오기 위한 통신
    function fetchGetTechStackInfo() {
        fetch(techStackURL + "/list", {
            method: 'GET',
            headers: {'content-type': 'application/json'},
        })
            .then(res => res.json())
            .then(info => {
                fetchInfo(info, "techStack")
            })
    }

    //fetch 내용에 따라 출력처리
    function fetchInfo(info, fetchName) {
        const {error} = info
        if (error) {
            alert(error.toString())
            location.href = "/";
        }

        // fetch 내용이 techStack일 경우
        if(fetchName === "techStack") {
            const {techStacks} = info
            techStacks.forEach(tech => {
                console.log(`techId : \${tech.techId}`);
                console.log(`techName : \${tech.techName}`);
                console.log(`techInfo : \${tech.techInfo}`);
            })
        }
    }

    fetchGetTechStackInfo();
</script>
</html>