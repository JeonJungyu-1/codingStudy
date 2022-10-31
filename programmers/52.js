//부족한 금액 계산하기
function solution(price, money, count) {
    let sumPrice = count * (2 * price + (count - 1) * price) / 2;
    let answer = sumPrice - money;
    return answer > 0 ? answer : 0;
}
