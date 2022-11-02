//제일 작은 수 제거하기
function solution(arr) {
    let answer;
    if (arr[0] === 10) return [-1]
    
    let minNum = Math.min(...arr);
    answer = arr.filter(el => el > minNum);
    return answer;
}