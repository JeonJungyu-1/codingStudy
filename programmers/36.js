//최댓값과 최솟값
function solution(s) {
    let numArr = s.split(" ");
    
    let answer = `${Math.min(...numArr)} ${Math.max(...numArr)}`;
    return answer;
}