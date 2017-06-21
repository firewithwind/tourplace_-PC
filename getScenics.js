'use strict'

function get(){
  // $.get('localhost/tourplace/src/scenic.php',{
  //   Type: 3,
  //   Keys: "Scenic_ID+Scenic_Name+Scenic_Picture",
  //   Page: 1,
  //   PageSize: 8,
  //   Search: {
  //     Province_ID: "",
  //     City_ID: "",
  //     Scenic_Level: ''
  //   }
  // })
  // .done(function(response){
  //   var res = JSON.parse(response)
  //   if(res.Type == 0){
  //     // self.locationScenics = res.Result
  //     // for(var key in self.locationScenics){
  //     //   self.locationScenicUrls.push('/tourplace/components/content/scenic/scenic.html?id=' + self.locationScenics[key].Scenic_ID)
  //     // }
  //     return "request ok"
  //   }else{
  //     return "request failed"
  //   }
  // })
  // .fail(function(){
  //   return "发生了未知的错误"
  // })


  var xhr = new XMLHttpRequest;
  xhr.open("get","localhost/tourplace/src/scenic.php",false);
  x.send(null);
  if ((xhr.status >= 200 && xhr.status < 300) || xhr.status == 304){
    print(xhr.responseText);
  } else {
    print("Request was unsuccessful: " + xhr.status);
  }
  // print("OK")
}
get()
