//튜플
function solution(s) {
    let answer = [];
    const set = new Set();
    const sArr = s.slice(2, s.length - 2).split("},{").sort((a, b) => a.length - b.length);
    for (let i = 0; i < sArr.length; i++) {
        sArr[i].split(",").map(el => set.add(Number(el)));
    }
    answer = Array.from(set);
    return answer;
}