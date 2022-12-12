//2016년
function solution(a, b) {
    let answer = '';
    const week = ["SUN", "MON", "TUE", "WED", "THU", "FRI", "SAT"];
    let date = new Date(2016, a - 1, b);
    answer = week[date.getDay()];
    return answer;
}