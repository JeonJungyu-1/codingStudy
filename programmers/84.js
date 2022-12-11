//문자열 내 p와 y의 개수
function solution(s){
    let answer = true;
    if (s.toLowerCase().split("p").length !== s.toLowerCase().split("y").length) {  
        answer = false;
    }
    
    return answer;
}