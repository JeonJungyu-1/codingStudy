//행렬 테두리 회전하기
function solution(rows, columns, queries) {
    let answer = [];
    let table = [];
    for (let i = 0; i < columns; i++) {
        table.push([]);
        for (let j = 0; j < rows; j++) {
            table[i].push(i * columns + j + 1);
        } 
    }
    
    // console.log(table);

    queries.map((el, index) => {
        const m = el[2] - el[0];
        const n = el[3] - el[1];
        console.log(m, n);
        const tmpArr = table.map((el) => [...el]);

        for (let i = 0; i < m; i++ ) {
            for (let j = 0; j < n; j++) {
                tmpArr[i][j] = table[m-1-j][i];
            }
        }
        
        for (let i = 0; i < m; i++ ) {
            for (let j = 0; j < n; j++) {
                tmpArr[i][j] = table[m-1-j][i];
            }
        }  
    })
    // if (rows)
    // console.log(tmpArr);
    return answer;
}