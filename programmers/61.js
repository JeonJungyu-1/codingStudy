//가운데 글자 가져오기
function solution(s) {
    let answer = '';
    if (s.length % 2 === 1) {
        answer = s[s.length/2 - 0.5];    
    } else {
        answer = s.slice(s.length/2 - 1, s.length/2 + 1);
    }
    return answer;
}