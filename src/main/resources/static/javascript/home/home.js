var Home = (function(){
  var current = this;
  function init(userId){
    current.userId = userId;
    loadProductHistory();
    loadRelatedProducts();
    loadTrendingProducts();
  }

  function getProduct(productId){

  }

  function loadProductHistory(){
    $.ajax({
      url: "/productHistory",
      data: { userId: current.userId },
      success: function(data){
        renderProducts($(".productHistory"), "No Products Viewed", data);
      }
    })
  };

  function loadRelatedProducts(){
    $.ajax({
      url: "/relatedProducts",
      data: { userId: current.userId },
      success: function(data){
        renderProducts($(".relatedProducts"), "No Related Products found", data);
      }
    })
  };

  function loadTrendingProducts(){
    $.ajax({
      url: "/trendingProducts",
      data: { },
      success: function(data){
        renderProducts($(".trendingProducts"), "No Products Trending", data);
      }
    })
  }

  function renderProducts($target, noneFoundMessage, products){
    if(products.length){
      for(var i = 0; i < products.length; i++){
        renderProduct($target, products[i]);
      }
    } else {
      $target.append("<div class='col-md-12 noneFound'>" + noneFoundMessage + "</div>")
    }
  }

  function renderProduct($target, productData){
    var $product = $("<div class='col-md-3 product' data-id='" + productData.id + "'>" +
      "<span class='name'>" + productData.name + "</span>" +
      "<img src='/images/" + productData.imageUrl +"' />" +
      "</div>")
    $target.append($product);
    $product.on("click", function(){
      var productId = $(this).data('id');
      getProduct(productId);
    });
  }

  return {
    init: init
  }
})();