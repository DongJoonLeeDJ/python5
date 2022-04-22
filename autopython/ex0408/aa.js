const bb = ()=>{
    console.log("bb");
}

function aa(){
    console.log("aa");
}

function main(myfunc,var1){
    myfunc();
}

main(aa);
main(bb);

main( ()=>{ console.log('함수만들기'); }  ,  10);

// 매개변수로.. 변수를 넘기는게 익숙한데...
// 2017년도... 모든 개발자... 이거 별로야.. 22년..