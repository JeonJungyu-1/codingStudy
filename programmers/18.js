//행렬 테두리 회전하기
function solution(rows, columns, queries) {
    let answer = [];
    let table = [];
    for (let i = 0; i < rows; i++) {
        table.push([]);
        for (let j = 0; j < columns; j++) {
            table[i].push(i * columns + j + 1);
        } 
    }        
    const tmpArr = table.map((el) => [...el]);

    for (let el of queries) {
        let minNum = 0;
        
        function isMinNum(num) {
            if (!minNum || minNum > num) {
                minNum = num;
            }
        }
        
        if (el[0] === 1 && el[1] === 1 && el[2] === columns && el[3] === rows) {
            answer.push(1);
            continue;
        } 
        
        //임시배열에 차례대로 회전한 값 담기
        for (let i = el[1] - 1; i < el[3] - 1; i++) {
            tmpArr[el[0] - 1][i + 1] = table[el[0] - 1][i];
        }
        for (let i = el[0] - 1; i < el[2] - 1; i++) {
            tmpArr[i + 1][el[3] - 1] = table[i][el[3] - 1];
        }
        for (let i = el[1] - 1; i < el[3] - 1; i++) {
            tmpArr[el[2] - 1][i] = table[el[2] - 1][i + 1];
        }
        for (let i = el[0] - 1; i < el[2] - 1; i++) {
            tmpArr[i][el[1] - 1] = table[i + 1][el[1] - 1];
        }
        
        
        //임시배열에서 값 다시 가져오기
        for (let i = el[1] - 1; i < el[3] - 1; i++) {
            table[el[0] - 1][i + 1] = tmpArr[el[0] - 1][i + 1];
            isMinNum(table[el[0] - 1][i + 1]);
        }
        for (let i = el[0] - 1; i < el[2] - 1; i++) {
            table[i + 1][el[3] - 1] = tmpArr[i + 1][el[3] - 1];
            isMinNum(table[i + 1][el[3] - 1]);
        }
        for (let i = el[1] - 1; i < el[3] - 1; i++) {
            table[el[2] - 1][i] = tmpArr[el[2] - 1][i];
            isMinNum(table[el[2] - 1][i]);
        }
        for (let i = el[0] - 1; i < el[2] - 1; i++) {
            table[i][el[1] - 1] = tmpArr[i][el[1] - 1];
            isMinNum(table[i][el[1] - 1]);
        }
        
        answer.push(minNum);
    }
    return answer;
}