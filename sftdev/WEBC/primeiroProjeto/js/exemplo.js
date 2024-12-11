

function generateRandomIntegers(parametro){
    for (i=0;i<parametro;i++){
        console.log((Math.random()*100).toFixed(0))
    }
}

function valorEntreDois(x,y){
    if (x<y){
        console.log(((Math.random()*(y-x))+x).toFixed(0))
    }
    else{
        console.log((Math.random()*(x-y))+y)
    }
}

valorEntreDois(1,5)