describe("Home", function(){
  var flagOn;
  beforeEach(function(){
    affix(".productHistory");
    affix(".relatedProducts");
    affix(".trendingProducts");
    flagOn = false;
    spyOn(CongoUtils, "goToUrl").and.callFake(function(url){});
  });

  it("is defined", function(){
    expect(Home).toBeDefined();
  });

  describe("product history", function(){

    it("retrieves the product history for the user", function(){
      var invoked = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("History") != -1){
          invoked = true;
          expect(request.url).toBe("/productHistory");
          expect(request.data).toEqual({userId: 1});
        }
      });

      Home.init(1, flagOn);

      expect($.ajax).toHaveBeenCalled();
      expect(invoked).toBe(true);
    });

    it("renders the products that are returned", function(){
      var successCalled = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("History") != -1) {
          var product = {
            id: 1,
            name: "product1",
            url: "product1url",
            imageUrl: "product1ImageUrl"
          };
          request.success([ product ]);
          successCalled = true;
          expect($(".productHistory .product").length).toBe(1);
          var $product = $(".productHistory .product");
          expect($product.data("id")).toBe(product.id);
          expect($product.find(".name").html()).toBe(product.name);
          expect($product.find("img").attr("src")).toBe("/images/" + product.imageUrl);
        }
      });

      Home.init(1, flagOn);

      expect(successCalled).toBe(true);
    });

    it("renders a No Products Viewed message when the history is empty of products", function(){
      var successCalled = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("History") != -1) {
          request.success([  ]);
          successCalled = true;
          expect($(".productHistory .product").length).toBe(0);
          expect($(".productHistory .noneFound")).toExist();
          expect($(".productHistory .noneFound").html()).toBe("No Products Viewed");
        }
      });

      Home.init(1, flagOn);

      expect(successCalled).toBe(true);
    });
  });

  describe("related products", function(){
    it("retrieves the related products for the user", function(){
      var invoked = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("related") != -1){
          invoked = true;
          expect(request.url).toBe("/relatedProducts");
          expect(request.data).toEqual({ userId: 1 });
        }
      });

      Home.init(1, flagOn);

      expect($.ajax).toHaveBeenCalled();
      expect(invoked).toBe(true);
    });

    it("renders the products that are returned", function(){
      var successCalled = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("related") != -1){
          var product = {
            id: 1,
            name: "product1",
            url: "product1url",
            imageUrl: "product1ImageUrl"
          };
          request.success([ product ]);
          successCalled = true;
          expect($(".relatedProducts .product").length).toBe(1);
          var $product = $(".relatedProducts .product");
          expect($product.data("id")).toBe(product.id);
          expect($product.find(".name").html()).toBe(product.name);
          expect($product.find("img").attr("src")).toBe("/images/" + product.imageUrl);
        }
      });

      Home.init(1, flagOn);

      expect(successCalled).toBe(true);
    });

    it("renders a No Related Products found message when the history is empty of products", function(){
      var successCalled = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("related") != -1) {
          request.success([  ]);
          successCalled = true;
          expect($(".relatedProducts .product").length).toBe(0);
          expect($(".relatedProducts .noneFound")).toExist();
          expect($(".relatedProducts .noneFound").html()).toBe("No Related Products found");
        }
      });

      Home.init(1, flagOn);

      expect(successCalled).toBe(true);
    });
  });

  describe("trending products", function(){
    it("retrieves the global trending products", function(){
      var invoked = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("trending") != -1){
          invoked = true;
          expect(request.url).toBe("/trendingProducts");
          expect(request.data).toEqual({});
        }
      });

      Home.init(1, flagOn);

      expect($.ajax).toHaveBeenCalled();
      expect(invoked).toBe(true);
    });

    it("renders the products that are returned", function(){
      var successCalled = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("trending") != -1){
          var product = {
            id: 1,
            name: "product1",
            url: "product1url",
            imageUrl: "product1ImageUrl"
          };
          request.success([ product ]);
          successCalled = true;
          expect($(".trendingProducts .product").length).toBe(1);
          var $product = $(".trendingProducts .product");
          expect($product.data("id")).toBe(product.id);
          expect($product.find(".name").html()).toBe(product.name);
          expect($product.find("img").attr("src")).toBe("/images/" + product.imageUrl);
        }
      });

      Home.init(1, flagOn);

      expect(successCalled).toBe(true);
    });

    it("renders a No Products Trending message when the history is empty of products", function(){
      var successCalled = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("trending") != -1) {
          request.success([  ]);
          successCalled = true;
          expect($(".trendingProducts .product").length).toBe(0);
          expect($(".trendingProducts .noneFound")).toExist();
          expect($(".trendingProducts .noneFound").html()).toBe("No Products Trending");
        }
      });

      Home.init(1, flagOn);

      expect(successCalled).toBe(true);
    });
  });

  describe("selecting a product for flag off", function(){
    beforeEach(function(){
      flagOn = false;
    })
    var product = {
        id: 1,
        name: "product1",
        description: "description1",
        price: "$3.50",
        url: "product1url",
        imageUrl: "product1ImageUrl"
      };

    it("retrieves product details", function(){
      var invoked = false;
      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("History") != -1) {
          request.success([ product ]);
          $(".product[data-id='1']").click();
        }

        if(request.url == "/product"){
          invoked = true;
          expect(request.data).toEqual({id: 1});
        }
      });

      Home.init(1, flagOn);

      expect($.ajax).toHaveBeenCalled();
      expect(invoked).toBe(true);
    });

    it("renders the product details in a modal when product is clicked", function(){
      var invoked = false;
      spyOn(bootbox, "dialog").and.callFake(function(options){
        invoked = true;
        expect(options.title).toBe(product.name);
        expect(options.size).toBe("large");
        expect(options.message.indexOf(product.price)).not.toBe(-1);
        expect(options.message.indexOf(product.description)).not.toBe(-1);
        expect(options.message.indexOf(product.imageUrl)).not.toBe(-1);
        expect(options.message.indexOf(product.url)).not.toBe(-1);
      });

      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("History") != -1) {
          request.success([ product ]);
          $(".product[data-id='1']").click();
        }
        if(request.url == "/product"){
          request.success(product);
        }
      });

      Home.init(1, flagOn);

      expect($.ajax).toHaveBeenCalled();
      expect(invoked).toBe(true);
    });
  });

  describe("selecting a product for flag on", function(){
    beforeEach(function(){
      flagOn = true;
    })
    it("takes the user to the product page", function(){
      var product = {
        id: 1,
        name: "product1",
        description: "description1",
        price: "$3.50",
        url: "product1url",
        imageUrl: "product1ImageUrl"
      };

      spyOn($, "ajax").and.callFake(function(request){
        if(request.url.indexOf("History") != -1) {
          request.success([ product ]);
          $(".product[data-id='1']").click();
        }
        if(request.url == "/product"){
          request.success(product);
        }
      });

      Home.init(1, flagOn);

      expect($.ajax).toHaveBeenCalled();
      expect(CongoUtils.goToUrl).toHaveBeenCalledWith("/product/" + product.id);
    });
  });
});