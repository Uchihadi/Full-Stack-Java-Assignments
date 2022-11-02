export const http PostwithHeader = (EndptURL, requestParam) => {
    let userId = localStorage.getItem ("userId");
    let token = localStorage.getItem ("token");
    return fetch ("http://localhost:8080/" + EndptURL,{
        method: "POST",
        headers: {
            "content-type": "application/json",
            "token": token,
            "userId": userId
        }, body:JSON.stringify(requestParam)
    },    
    )
}

export const httpGetWithHeader = (EndptURL) => {
    let userId = localStorage.getItem("userId");
    let token = localStorage.getItem("token");
    return fetch("http://localhost:8080/" + EndptURL,{
        method:"GET",
        headers:{
            "content-type": "application/json",
            "token": token,
            "userId": userId
        }
    }
    )
}

export const httpPostWithoutHeader = (EndptURL, requestParam) => {
    return fetch("http://localhost:8000/" +EndptURL,{
        method:"POST",
        body:JSON.stringify(requestParam,
            headers:{
                "content-type":"application/json",
            })
    }
    )
}