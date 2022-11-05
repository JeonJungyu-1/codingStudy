//푸드 파이트 대회
function solution(food) {
    let answer = '';
    let foodCount;
    for (let i = 1; i < food.length; i++) {
        foodCount = Math.floor(food[i] / 2);
        answer += `${i}`.repeat(foodCount);
    }
    answer = answer + "0" + answer.split("").reverse().join("");
    return answer;
}