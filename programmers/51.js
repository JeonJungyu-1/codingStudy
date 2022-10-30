//행렬의 곱셈
function solution(arr1, arr2) {
    let answer = [];
    let temp = 0;
    let tempArr = [];
    for (let i = 0; i < arr1.length; i++) {
        for (let j = 0; j < arr2[0].length; j++) {
            for (let k = 0; k < arr1[0].length; k++) {
                temp += arr1[i][k] * arr2[k][j];
            }
            tempArr.push(temp);
            temp = 0;
        }
        answer.push(tempArr)
        tempArr = [];
    }
    return answer;
}
