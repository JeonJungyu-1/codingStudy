//나머지가 1이 되는 수 찾기
function solution(n) {
    let answer = 0;
    for (let i = 0; i < n; i++) {
        if (n % i === 1) {
            answer = i;
            break;
        }
    }
    return answer;
}