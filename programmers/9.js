//신고결과 받기
function solution(id_list, report, k) {
    //중복제거
    let reportSet = new Set(report);
    let reportArray = [...reportSet];
    let result = [];
    //이름하고 횟수 넣은 객체를 만들어야지
    let result1 = new Map();
    let i = 0;
    id_list.map((el)=>{result1.set(el, 0); result[i] = 0; i++; return el});
    
    reportArray.map((el) => {
        let [haver, had] = el.split(' '); 
         result1.set(had, result1.get(had) + 1);
    })
    
    
    reportArray.map((el) => {
        let [haver, had] = el.split(' '); 
        if (result1.get(had) >= k) {
                result[id_list.indexOf(haver)] += 1;      
        }
    })
    
    
    return result;
}