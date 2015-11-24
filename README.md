# MVPGeneric
项目中使用mvp分层，并且使用泛型。
activity 实现的是  v层的接口，为了减少v层必须实现的函数，所以在接口上分类，分为获取t和list，加上四种接口，共八个view
mvp中的m与  request相关，v层与response相关，p层与request，response均相关。

presenter、view全部是针对model来进行操作，而不是面向功能进行操作。
presenter 有四个请求类型，list或bean，get方法中不带参数，那么就有七种情况。只有其他请求带不带参数，可以使用同一个方法进行处理。
view  有四个类型，返回为list或bean，共有八种情况。


网络请求情况
网络请求方法（4种）×  传递的参数是list或bean（2种）  ×  返回的参数是list或bean（两种） -get不能传递参数×2  = 14种。

v层只关注response，m层只关注request，所以v层分为4×2，m成分为4×2-1（get不携带参数，所以不用区参数类型），共七种。
p层有14种，那么14种中每个presenter中有两个方法，针对参数是list或者单独的bean，get请求除外。