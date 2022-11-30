//실패율
function solution(N, stages) {
    let answer = [];
    for (let i = 1; i < N + 1; i++) {
        let temp = stages.filter((el) => el === i).length / stages.filter((el) => el >= i).length;
        answer.push({num : i, fail: temp});
    }
    
    answer = answer.sort(sortFunction).map((el) => el.num);
    return answer;
}

const sortFunction = (a, b) => {
    if (a.fail !== b.fail) {
        return b.fail - a.fail;
    } else {
        return a.num - b.num;
    }
}