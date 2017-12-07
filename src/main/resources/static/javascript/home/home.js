var Home = (function(){
  var current = this;
  function init(userId, flagOn){
    current.userId = userId;
    current.flagOn = flagOn;
    loadProductHistory();
    loadRelatedProducts();
    loadTrendingProducts();
  }

  function getProduct(productId){
    if(current.flagOn){
      CongoUtils.goToUrl("/product/" + productId);
    } else {
      $.ajax({
        url: "/product",
        data: {id: productId},
        success: renderProductModal
      });
    }
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

  function renderProductModal(productData){
    var message = "<div class='row'>";
      message += "<div class='col-md-3'><img src='images/" + productData.imageUrl +"' /></div>";
      message += "<div class='col-md-9'>";
        message += "<div><b>Price:</b> " + productData.price +"<button class='btn btn-outline-success checkout'><i class='fa fa-shopping-cart'></i></button></div>"

        message += "<div><b>Description:</b> " + productData.description + "</div>";
        message += "<div><a href='" + productData.url + "' target='_' class='btn btn-block'>Full Product Details</a></div>";
      message += "</div>";
    message += "</div>";
    bootbox.dialog({
      title: productData.name,
      size: "large",
      message: message
    });
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