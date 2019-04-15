<%@ page contentType="text/html;charset=UTF-8" %>
<%@ include file="../include/taglib.jsp"%>

<!DOCTYPE html>
<html class="no-js" lang="en"><head>
    <!-- Meta tag -->
    <meta charset="utf-8">
    <meta http-equiv="x-ua-compatible" content="ie=edge">
    <meta name="description" content="welcome to codeglim">
    <meta name='copyright' content='codeglim'>
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <!-- Title Tag -->
    <title>Bizpro  &minus; One Page Business and Corporate HTML Template</title>

    <!-- Favicon -->
    <link rel="icon" type="image/png" href="images/favicon.png">

    <!-- Google Font -->
    <link href="https://fonts.googleapis.com/css?family=Roboto:300,300i,400,400i,500,700,900" rel="stylesheet">



    <!-- Font Awesome CSS -->
    <link rel="stylesheet" href="${ctx}/css/font-awesome.min.css">

    <!-- Animate CSS -->
    <link rel="stylesheet" href="${ctx}/css/animate.min.css">

    <!-- Slicknav CSS -->
    <link rel="stylesheet" href="${ctx}/css/slicknav.min.css">

    <!-- Owl Carousel CSS -->
    <link rel="stylesheet" href="${ctx}/css/owl.theme.default.css">
    <link rel="stylesheet" href="${ctx}/css/owl.carousel.min.css">

    <!-- Magnific Popup CSS -->
    <link rel="stylesheet" href="${ctx}/css/magnific-popup.css">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="${ctx}/css/bootstrap.min.css">

    <!-- Bizpro Style CSS -->
    <link rel="stylesheet" href="${ctx}/css/style.css">
    <link rel="stylesheet" href="${ctx}/css/default.css">
    <link rel="stylesheet" href="${ctx}/css/responsive.css">

    <!-- You Can Use 8 Different color Just remove bottom of the comment tag -->

    <link rel="stylesheet" href="${ctx}/css/skin/green.css">
    <!--<link rel="stylesheet" href="css/skin/pink.css">-->
    <!--<link rel="stylesheet" href="css/skin/yellow.css">-->
    <!--<link rel="stylesheet" href="css/skin/red.css">-->
    <!--<link rel="stylesheet" href="css/skin/pink.css">-->
    <!--<link rel="stylesheet" href="css/skin/orange.css">-->
    <!--<link rel="stylesheet" href="css/skin/blaze.css">-->
    <!--<link rel="stylesheet" href="css/skin/blue.css">-->

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <link rel="stylesheet" href="#" id="colors">
</head>
<body>

<!-- Preloader -->
<div class="loader">
    <div class="l-inner">
        <div class="k-spinner">
            <div class="k-bubble-1"></div>
            <div class="k-bubble-2"></div>
        </div>
    </div>
</div>
<!--/ End Preloader -->

<!-- Mp Color -->
<div class="mp-color">
    <div class="icon inOut"><i class="fa fa-cog fa-spin"></i></div>
    <h4>Choose Color</h4>
    <span class="color1"></span>
    <span class="color2"></span>
    <span class="color3"></span>
    <span class="color4"></span>
    <span class="color5"></span>
    <span class="color6"></span>
    <span class="color7"></span>
    <span class="color8"></span>
</div>
<!--/ ENd Mp Color -->

<!-- Start Header -->
<header id="header">
    <div class="container">
        <div class="row">
            <div class="col-md-2 col-sm-12 col-xs-12">
                <!-- Logo -->
                <div class="logo">
                    <a href="index.html"><span>biz</span>pro</a>
                </div>
                <!--/ End Logo -->
            </div>
            <div class="col-md-8 col-sm-12 col-xs-12">
                <div class="nav-area">
                    <!-- Main Menu -->
                    <nav class="mainmenu">
                        <div class="mobile-nav"></div>
                        <div class="collapse navbar-collapse">
                            <ul class="nav navbar-nav menu">
                                <li class="active"><a href="#j-slider">Home</a></li>
                                <li><a href="#about-us">About Us</a></li>
                                <li><a href="#our-skill">Our Skill</a></li>
                                <li><a href="#why-choose">Why Choose</a></li>
                                <li><a href="#portfolio">Portfolio</a></li>
                                <li><a href="#blog">Blog</a></li>
                                <li><a href="#location">Contact</a></li>
                                <shiro:guest>
                                    <li><a href="${ctx}/login.html">登陆</a></li>
                                </shiro:guest>
                                <shiro:user>
                                    欢迎[<shiro:principal/>]登陆，<a href="${ctx}/logout.html">退出</a>
                                </shiro:user>
                            </ul>
                        </div>
                    </nav>
                    <!--/ End Main Menu -->
                </div>
            </div>
            <div class="col-md-2">
                <!-- Social -->
                <ul class="social">
                    <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                    <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                    <li class="active"><a href="#"><i class="fa fa-linkedin"></i></a></li>
                    <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                </ul>
                <!--/ End Social -->
            </div>
        </div>
    </div>
</header>
<!--/ End Header -->

<!-- Start Slider -->
<section id="j-slider">
    <div class="slide-main">
        <!-- Single Slider -->
        <div class="single-slider" style="background-image:url(../images/slider/slider-bg1.jpg);" >
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-12 col-xs-12">
                        <!-- Slider Text -->
                        <div class="slide-text left">
                            <div class="slider-inner">
                                <h1><span>we create</span>awesome business website</h1>
                                <p>Lorem  ipsum dolor sit amet, ad mea evertitur voluptaria constituam, usu id graecis legendos mediocritatem, labitur iracundia vituperata eu hasPersequeris dissentiunt eam et. Offendit</p>
                                <div class="slide-button">
                                    <a href="#" class="button primary">Contact Us</a>
                                </div>
                            </div>
                        </div>
                        <!--/ End Slider Text -->
                    </div>
                </div>
            </div>
        </div>
        <!--/ End Single Slider -->
        <!-- Single Slider -->
        <div class="single-slider" style="background-image:url(../images/slider/slider-bg2.jpg);" >
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-12 col-xs-12">
                        <!-- Slider Text -->
                        <div class="slide-text left">
                            <div class="slider-inner">
                                <h1><span>we create</span>awesome business website</h1>
                                <p>Lorem  ipsum dolor sit amet, ad mea evertitur voluptaria constituam, usu id graecis legendos mediocritatem, labitur iracundia vituperata eu hasPersequeris dissentiunt eam et. Offendit</p>
                                <div class="slide-button">
                                    <a href="#" class="button primary">Contact Us</a>
                                </div>
                            </div>
                        </div>
                        <!--/ End Slider Text -->
                    </div>
                </div>
            </div>
        </div>
        <!--/ End Single Slider -->
        <!-- Single Slider -->
        <div class="single-slider" style="background-image:url(../images/slider/slider-bg3.jpg);" >
            <div class="container">
                <div class="row">
                    <div class="col-md-8 col-sm-12 col-xs-12">
                        <!-- Slider Text -->
                        <div class="slide-text left">
                            <div class="slider-inner">
                                <h1><span>we create</span>awesome business website</h1>
                                <p>Lorem  ipsum dolor sit amet, ad mea evertitur voluptaria constituam, usu id graecis legendos mediocritatem, labitur iracundia vituperata eu hasPersequeris dissentiunt eam et. Offendit</p>
                                <div class="slide-button">
                                    <a href="#" class="button primary">Contact Us</a>
                                </div>
                            </div>
                        </div>
                        <!--/ End Slider Text -->
                    </div>
                </div>
            </div>
        </div>
        <!--/ End Single Slider -->
    </div>
</section>
<!--/ End Slider -->

<!-- Start Service -->
<section id="service" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 wow fadeIn">
                <div class="section-title center">
                    <h2>Our <span>Service</span></h2>
                    <p>Coordinates for abs potioning the closest positioned parent box of the positioned abs qoning the closes for abs potioning the closest positioned parent.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <!-- Single Service -->
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.4s">
                <div class="single-service">
                    <i class="fa fa-check"></i>
                    <h2>Web Design</h2>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
                </div>
            </div>
            <!--/ End Single Service -->
            <!-- Single Service -->
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.6s">
                <div class="single-service">
                    <i class="fa fa-edit"></i>
                    <h2>Web Developments</h2>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
                </div>
            </div>
            <!--/ End Single Service -->
            <!-- Single Service -->
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.8s">
                <div class="single-service">
                    <i class="fa fa-send"></i>
                    <h2>Smart Coding</h2>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
                </div>
            </div>
            <!--/ End Single Service -->
            <!-- Single Service -->
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="1s">
                <div class="single-service">
                    <i class="fa fa-code"></i>
                    <h2>UI/UX Design</h2>
                    <p>Lorem ipsum dolor sit amet, consectetuer adipiscing elit, sed diam nonummy.</p>
                </div>
            </div>
            <!--/ End Single Service -->
        </div>
    </div>
</section>
<!--/ End Service -->

<!-- Start About Us -->
<section id="about-us" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 wow fadeIn">
                <div class="section-title center">
                    <h2>About <span>US</span></h2>
                    <p>Coordinates for abs potioning the closest positioned parent box of the positioned abs qoning the closes for abs potioning the closest positioned parent.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <!-- About Image -->
            <div class="col-md-5 col-sm-12 col-xs-12 wow slideInLeft">
                <div class="about-main">
                    <div class="about-img">
                        <img src="${ctx}/images/about.jpg" alt=""/>
                    </div>
                </div>
            </div>
            <!--/ End About Image -->
            <div class="col-md-7 col-sm-12 col-xs-12 wow fadeIn" data-wow-delay="1s">
                <!-- About Tab -->
                <div class="tabs-main">
                    <!-- Tab Nav -->
                    <ul class="nav nav-tabs" role="tablist">
                        <li role="presentation" class="active"><a href="#welcome"  data-toggle="tab">Welcome</a></li>
                        <li role="presentation"><a href="#about" data-toggle="tab">About Us</a></li>
                        <li role="presentation"><a href="#information"  data-toggle="tab">Information</a></li>
                    </ul>
                    <!--/ End Tab Nav -->
                    <!-- Tab Content -->
                    <div class="tab-content">
                        <div role="tabpanel" class="tab-pane fade in active" id="welcome">
                            <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.</p>
                            <div class="row">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <!-- Single Tab -->
                                    <div class="single-tab">
                                        <i class="fa fa-check"></i>
                                        <h4>Super Technology</h4>
                                        <p>It has roots in a piece of classical Latin literature from 45 BC[..]</p>
                                    </div>
                                    <!--/ End Single Tab -->
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <!-- Single Tab -->
                                    <div class="single-tab">
                                        <i class="fa fa-support"></i>
                                        <h4>Live Support</h4>
                                        <p>It has roots in a piece of classical Latin literature from 45 BC[..]</p>
                                    </div>
                                    <!--/ End Single Tab -->
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <!-- Single Tab -->
                                    <div class="single-tab">
                                        <i class="fa fa-send"></i>
                                        <h4>fast Delivery</h4>
                                        <p>It has roots in a piece of classical Latin literature from 45 BC[..]</p>
                                    </div>
                                    <!--/ End Single Tab -->
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <!-- Single Tab -->
                                    <div class="single-tab">
                                        <i class="fa fa-rocket"></i>
                                        <h4>Speed Marketing</h4>
                                        <p>It has roots in a piece of classical Latin literature from 45 BC[..]</p>
                                    </div>
                                    <!--/ End Single Tab -->
                                </div>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade in" id="about">
                            <div class="about">
                                <p>Aliquam erat volutpat. Phasellus lobortis erat vitae fringilla malesuada. Fusce semper purus suscipit ultricies tincidunt. Nulla eget turpis ac leo euismod pharetra at nec diam. Etiam id purus lacus. Suspendisse ligula nulla, cursus non lacinia tincidunt, elementum eu sapien</p>
                                <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.</p>
                                <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.</p>
                            </div>
                        </div>
                        <div role="tabpanel" class="tab-pane fade in" id="information">
                            <p>Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin literature from 45 BC, making it over 2000 years old.</p>
                            <div class="row">
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <!-- Single Tab -->
                                    <div class="single-tab">
                                        <i class="fa fa-check"></i>
                                        <h4>Super Technology</h4>
                                        <p>It has roots in a piece of classical Latin literature from 45 BC[..]</p>
                                    </div>
                                    <!--/ End Single Tab -->
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <!-- Single Tab -->
                                    <div class="single-tab">
                                        <i class="fa fa-support"></i>
                                        <h4>Live Support</h4>
                                        <p>It has roots in a piece of classical Latin literature from 45 BC[..]</p>
                                    </div>
                                    <!--/ End Single Tab -->
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <!-- Single Tab -->
                                    <div class="single-tab">
                                        <i class="fa fa-send"></i>
                                        <h4>fast Delivery</h4>
                                        <p>It has roots in a piece of classical Latin literature from 45 BC[..]</p>
                                    </div>
                                    <!--/ End Single Tab -->
                                </div>
                                <div class="col-md-6 col-sm-6 col-xs-12">
                                    <!-- Single Tab -->
                                    <div class="single-tab">
                                        <i class="fa fa-rocket"></i>
                                        <h4>Speed Marketing</h4>
                                        <p>It has roots in a piece of classical Latin literature from 45 BC[..]</p>
                                    </div>
                                    <!--/ End Single Tab -->
                                </div>
                            </div>
                        </div>
                    </div>
                    <!--/ End Tab Content -->
                </div>
                <!--/ End About Tab -->
            </div>
        </div>
    </div>
</section>
<!--/ End About Us -->
<div class="tlinks">Collect from <a href="http://www.cssmoban.com/"  title="网站模板">网站模板</a></div>
<!-- Our Skill -->
<section id="our-skill" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-12 col-xs-12 wow fadeIn">
                <!-- Info Main -->
                <div class="info-main">
                    <div class="section-title left">
                        <h2>Some <span>Info</span></h2>
                    </div>
                    <div class="some-info">
                        <p>Morbi laoreet urna ante, quis luctus nisi sodales sit amet. Aliquam a enim in massa molestie mollis. Proin quis velit at nisl vulputate egestas non in arcu.Ut sodales eleifend sapien at fermentum.</p>
                    </div>
                    <ul class="info-list">
                        <li><i class="fa fa-check"></i>consectetuer adipiscing elit, sed diam nonummy.</li>
                        <li><i class="fa fa-check"></i>has been the industry'sstandar.</li>
                        <li><i class="fa fa-check"></i>has been the industry'sstandar.</li>
                        <li><i class="fa fa-check"></i>Pellentesque habitant morbi tristique senectus.</li>
                    </ul>
                </div>
                <!--/ End Info Main -->
            </div>
            <div class="col-md-6 col-sm-12 col-xs-12">
                <!-- Skill Main -->
                <div class="skill-main">
                    <div class="section-title left">
                        <h2>Our <span>Skills</span></h2>
                    </div>
                    <!-- Single Skill -->
                    <div class="single-skill">
                        <div class="skill-info">
                            <h4>Creative</h4>
                        </div>
                        <div class="progress">
                            <div class="progress-bar" data-percent="80"><span>80%</span></div>
                        </div>
                    </div>
                    <!--/ End Single Skill -->
                    <!-- Single Skill -->
                    <div class="single-skill">
                        <div class="skill-info">
                            <h4>Web Design</h4>
                        </div>
                        <div class="progress">
                            <div class="progress-bar" data-percent="90"><span>90%</span></div>
                        </div>
                    </div>
                    <!--/ End Single Skill -->
                    <!-- Single Skill -->
                    <div class="single-skill">
                        <div class="skill-info">
                            <h4>Marketing</h4>
                        </div>
                        <div class="progress">
                            <div class="progress-bar" data-percent="70"><span>70%</span></div>
                        </div>
                    </div>
                    <!--/ End Single Skill -->
                    <!-- Single Skill -->
                    <div class="single-skill">
                        <div class="skill-info">
                            <h4>Success</h4>
                        </div>
                        <div class="progress">
                            <div class="progress-bar" data-percent="60"><span>95%</span></div>
                        </div>
                    </div>
                    <!--/ End Single Skill -->
                </div>
                <!--/ End Skill Main -->
            </div>
        </div>
    </div>
</section>
<!--/ End Our Skill -->

<!-- Why Choose Us -->
<div id="why-choose" class="section">
    <div class="why-image">
        <div class="video"><a href="https://www.youtube.com/watch?v=wZWiRoktNWA" class="video-play mfp-iframe wow zoomIn"><i class="fa fa-play"></i></a></div>
        <!-- <img src="images/video.png" alt=""> -->
    </div>
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-12 col-xs-12 pull-right">
                <h2>Why Choose Us?</h2>
                <p>Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima.</p>
                <div class="row">
                    <!-- Single Choose -->
                    <div class="col-md-6 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.4s">
                        <div class="single-choose">
                            <i class="fa fa-check"></i>
                            <h4>100 Awards</h4>
                        </div>
                    </div>
                    <!-- End Single Choose -->
                    <!-- Single Choose -->
                    <div class="col-md-6 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.6s">
                        <div class="single-choose">
                            <i class="fa fa-facebook"></i>
                            <h4>500K Fans</h4>
                        </div>
                    </div>
                    <!-- End Single Choose -->
                    <!-- Single Choose -->
                    <div class="col-md-6 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.8s">
                        <div class="single-choose">
                            <i class="fa fa-youtube"></i>
                            <h4>100K Subscriber</h4>
                        </div>
                    </div>
                    <!-- End Single Choose -->
                    <!-- Single Choose -->
                    <div class="col-md-6 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="1s">
                        <div class="single-choose">
                            <i class="fa fa-support"></i>
                            <h4>24/7 Support</h4>
                        </div>
                    </div>
                    <!-- End Single Choose -->
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ End Why Choose Us -->

<!-- Start Team -->
<section id="team" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 wow fadeIn">
                <div class="section-title center">
                    <h2>Lovely <span>Team</span></h2>
                    <p>Coordinates for abs potioning the closest positioned parent box of the positioned abs qoning the closes for abs potioning the closest positioned parent.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.4s">
                <!-- Single Team -->
                <div class="single-team">
                    <div class="team-head">
                        <%--<img src="${ctx}/images/team/team1.jpg" alt=""/>--%>
                    </div>
                    <div class="team-info">
                        <div class="name">
                            <h4>Trans L<span>Creative Director</span></h4>
                        </div>
                        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada</p>
                        <ul class="team-social">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                        </ul>
                    </div>
                </div>
                <!--/ End Single Team -->
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.6s">
                <!-- Single Team -->
                <div class="single-team">
                    <div class="team-head">
                        <%--<img src="${ctx}/images/team/team2.jpg" alt=""/>--%>
                    </div>
                    <div class="team-info">
                        <div class="name">
                            <h4>Augsed Lamp<span>Web Developer</span></h4>
                        </div>
                        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada</p>
                        <ul class="team-social">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                        </ul>
                    </div>
                </div>
                <!--/ End Single Team -->
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.8s">
                <!-- Single Team -->
                <div class="single-team active">
                    <div class="team-head">
                        <%--<img src="${ctx}/images/team/team3.jpg" alt=""/>--%>
                    </div>
                    <div class="team-info">
                        <div class="name">
                            <h4>Fronas Kie<span>Server Administor</span></h4>
                        </div>
                        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada</p>
                        <ul class="team-social">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                        </ul>
                    </div>
                </div>
                <!--/ End Single Team -->
            </div>
            <div class="col-md-3 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="1s">
                <!-- Single Team -->
                <div class="single-team">
                    <div class="team-head">
                        <%--<img src="${ctx}/images/team/team4.jpg" alt=""/>--%>
                    </div>
                    <div class="team-info">
                        <div class="name">
                            <h4>Lifae Hoadas<span>UI/UX Design</span></h4>
                        </div>
                        <p>Pellentesque habitant morbi tristique senectus et netus et malesuada</p>
                        <ul class="team-social">
                            <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                            <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                            <li><a href="#"><i class="fa fa-dribbble"></i></a></li>
                            <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                        </ul>
                    </div>
                </div>
                <!--/ End Single Team -->
            </div>
        </div>
    </div>
</section>
<!--/ End Team -->

<!-- Start Testimonials -->
<section id="testimonial" class="section wow fadeIn">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 wow fadeIn">
                <div class="section-title center">
                    <h2>Our <span>Testimonials</span></h2>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="testimonial-carousel">
                    <!-- Single Testimonial -->
                    <div class="single-testimonial">
                        <div class="testimonial-content">
                            <p> Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, </p>
                        </div>
                        <div class="testimonial-info">
                            <div class="img">
                                <span class="arrow"></span>
                                <%--<img src="${ctx}/images/testimonial1.jpg" class="img-circle" alt="">--%>
                            </div>
                            <h6>Trom<span>Founder Hoadas</span></h6>
                        </div>
                    </div>
                    <!--/ End Single Testimonial -->
                    <!-- Single Testimonial -->
                    <div class="single-testimonial">
                        <div class="testimonial-content">
                            <p> Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, </p>
                        </div>
                        <div class="testimonial-info">
                            <div class="img">
                                <span class="arrow"></span>
                                <%--<img src="${ctx}/images/testimonial2.jpg" class="img-circle" alt="">--%>
                            </div>
                            <h6>Trom<span>Founder Hoadas</span></h6>
                        </div>
                    </div>
                    <!--/ End Single Testimonial -->
                    <!-- Single Testimonial -->
                    <div class="single-testimonial">
                        <div class="testimonial-content">
                            <p> Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, </p>
                        </div>
                        <div class="testimonial-info">
                            <div class="img">
                                <span class="arrow"></span>
                                <%--<img src="${ctx}/images/testimonial3.jpg" class="img-circle" alt="">--%>
                            </div>
                            <h6>Trom<span>Founder Hoadas</span></h6>
                        </div>
                    </div>
                    <!--/ End Single Testimonial -->
                </div>
            </div>
        </div>
    </div>
</section>
<!--/ End Testimonial -->

<!-- Start Portfolio -->
<section id="portfolio" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 wow fadeIn">
                <div class="section-title center">
                    <h2>Our <span>Portfolio</span></h2>
                    <p>Coordinates for abs potioning the closest positioned parent box of the positioned abs qoning the closes for abs potioning the closest positioned parent.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="portfolio-carousel">
                    <!-- Single Portfolio -->
                    <div class="portfolio-single">
                        <a class="zoom">
                            <div class="portfolio-head">
                                <%--<img src="${ctx}/images/portfolio/1.jpg" alt=""/>--%>
                                <i class="fa fa-search"></i>
                            </div>
                        </a>
                        <div class="text">
                            <h4><a href="portfolio-single.html">Portfolio 1</a></h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam interdum.</p>
                        </div>
                    </div>
                    <!--/ End Portfolio -->
                    <!-- Single Portfolio -->
                    <div class="portfolio-single">
                        <a class="zoom">
                            <div class="portfolio-head">
                                <%--<img src="${ctx}/images/portfolio/2.jpg" alt=""/>--%>
                                <i class="fa fa-search"></i>
                            </div>
                        </a>
                        <div class="text">
                            <h4><a href="portfolio-single.html">Portfolio 2</a></h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam interdum.</p>
                        </div>
                    </div>
                    <!--/ End Portfolio -->
                    <!-- Single Portfolio -->
                    <div class="portfolio-single">
                        <a class="zoom">
                            <div class="portfolio-head">
                                <%--<img src="${ctx}/images/portfolio/3.jpg" alt=""/>--%>
                                <i class="fa fa-search"></i>
                            </div>
                        </a>
                        <div class="text">
                            <h4><a href="portfolio-single.html">Portfolio 3</a></h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam interdum.</p>
                        </div>
                    </div>
                    <!--/ End Portfolio -->
                    <!-- Single Portfolio -->
                    <div class="portfolio-single">
                        <a class="zoom">
                            <div class="portfolio-head">
                                <%--<img src="${ctx}/images/portfolio/4.jpg" alt=""/>--%>
                                <i class="fa fa-search"></i>
                            </div>
                        </a>
                        <div class="text">
                            <h4><a href="portfolio-single.html">Portfolio 4</a></h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam interdum.</p>
                        </div>
                    </div>
                    <!--/ End Portfolio -->
                    <!-- Single Portfolio -->
                    <div class="portfolio-single">
                        <a class="zoom">
                            <div class="portfolio-head">
                                <%--<img src="${ctx}/images/portfolio/5.jpg" alt=""/>--%>
                                <i class="fa fa-search"></i>
                            </div>
                        </a>
                        <div class="text">
                            <h4><a href="portfolio-single.html">Portfolio 5</a></h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam interdum.</p>
                        </div>
                    </div>
                    <!--/ End Portfolio -->
                    <!-- Single Portfolio -->
                    <div class="portfolio-single">
                        <a class="zoom">
                            <div class="portfolio-head">
                                <%--<img src="${ctx}/images/portfolio/6.jpg" alt=""/>--%>
                                <i class="fa fa-search"></i>
                            </div>
                        </a>
                        <div class="text">
                            <h4><a href="portfolio-single.html">Portfolio 6</a></h4>
                            <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nullam interdum.</p>
                        </div>
                    </div>
                    <!--/ End Portfolio -->
                </div>
            </div>
        </div>
    </div>
</section>
<!--/ End Portfolio -->

<!-- Start Statics -->
<section id="statics" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-12 col-xs-12">
                <div class="row">
                    <div class="statics">
                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <h2>World Domination!</h2>
                            <p>Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis per seacula quarta decima et quinta decima.</p>
                        </div>
                        <div class="col-md-6 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.4s">
                            <!-- Static Single -->
                            <div class="static-single">
                                <div class="number"><span class="counter">1300</span></div>
                                <p>Project Complete</p>
                            </div>
                        </div>
                        <!-- End Single -->
                        <!-- Static Single -->
                        <div class="col-md-6 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.6s">
                            <div class="static-single">
                                <div class="number"><span class="counter">123300</span></div>
                                <p>Support Tiket</p>
                            </div>
                        </div>
                        <!-- End Single -->
                        <!-- Static Single -->
                        <div class="col-md-6 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="0.8s">
                            <div class="static-single">
                                <div class="number"><span class="counter">55300</span></div>
                                <p>Global Clients</p>
                            </div>
                        </div>
                        <!-- End Single -->
                        <!-- Static Single -->
                        <div class="col-md-6 col-sm-6 col-xs-12 wow fadeIn" data-wow-delay="1s">
                            <div class="static-single">
                                <div class="number"><span class="counter">40.99</span><span class="percent">%</span></div>
                                <p>World Domination</p>
                            </div>
                        </div>
                        <!-- End Single -->
                    </div>
                </div>
            </div>
        </div>
    </div>
    <div class="static-image wow fadeIn"></div>
</section>
<!--/ End Statics -->

<!-- Start blog -->
<section id="blog" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12  wow fadeIn">
                <div class="section-title center">
                    <h2>Our <span>Blog</span></h2>
                    <p>Coordinates for abs potioning the closest positioned parent box of the positioned abs qoning the closes for abs potioning the closest positioned parent.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12">
                <div class="blog">
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <!-- Single blog -->
                        <div class="single-blog">
                            <div class="blog-head">
                                <%--<img src="${ctx}/images/blog/1.jpg" alt="#">--%>
                                <a href="blog-single.html" class="link"><i class="fa fa-link"></i></a>
                            </div>
                            <div class="blog-content">
                                <h2><a href="blog-single.html">We create one page business website</a></h2>
                                <div class="meta">
                                    <span><i class="fa fa-user"></i>admin</span>
                                    <span><i class="fa fa-calendar"></i>19 May</span>
                                    <span><i class="fa fa-comments"></i>5 Comments</span>
                                </div>
                                <p>Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis.</p>
                                <a href="blog-single.html" class="btn">Read More<i class="fa fa-angle-double-right"></i></a>
                            </div>
                        </div>
                        <!--/ End Single blog -->
                    </div>
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <!-- Single blog -->
                        <div class="single-blog">
                            <div class="blog-head">
                                <%--<img src="${ctx}/images/blog/2.jpg" alt="#">--%>
                                <a href="blog-single.html" class="link"><i class="fa fa-link"></i></a>
                            </div>
                            <div class="blog-content">
                                <h2><a href="blog-single.html">Super,Clean HTML5 Templates ever you seen!</a></h2>
                                <div class="meta">
                                    <span><i class="fa fa-user"></i>admin</span>
                                    <span><i class="fa fa-calendar"></i>19 May</span>
                                    <span><i class="fa fa-comments"></i>5 Comments</span>
                                </div>
                                <p>Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis.</p>
                                <a href="blog-single.html" class="btn">Read More<i class="fa fa-angle-double-right"></i></a>
                            </div>
                        </div>
                        <!--/ End Single blog -->
                    </div>
                    <div class="col-md-4 col-sm-6 col-xs-12">
                        <!-- Single blog -->
                        <div class="single-blog">
                            <div class="blog-head">
                                <%--<img src="${ctx}/images/blog/3.jpg" alt="#">--%>
                                <a href="blog-single.html" class="link"><i class="fa fa-link"></i></a>
                            </div>
                            <div class="blog-content">
                                <h2><a href="blog-single.html">Responsive Retina Ready Html template</a></h2>
                                <div class="meta">
                                    <span><i class="fa fa-user"></i>admin</span>
                                    <span><i class="fa fa-calendar"></i>19 May</span>
                                    <span><i class="fa fa-comments"></i>5 Comments</span>
                                </div>
                                <p>Mirum est notare quam littera gothica, quam nunc putamus parum claram, anteposuerit litterarum formas humanitatis.</p>
                                <a href="blog-single.html" class="btn">Read More<i class="fa fa-angle-double-right"></i></a>
                            </div>
                        </div>
                        <!--/ End Single blog -->
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>
<!--/ End blog -->

<!-- Contact Us -->
<section id="contact" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 wow fadeIn">
                <div class="section-title center">
                    <h2>Contact <span>US</span></h2>
                    <p>Coordinates for abs potioning the closest positioned parent box of the positioned abs qoning the closes for abs potioning the closest positioned parent.</p>
                </div>
            </div>
        </div>
        <!-- Google Map -->
        <div class="row">
            <!-- Contact Form -->
            <div class="col-md-5 col-sm-5 col-xs-12">
                <form class="form" method="post" action="mail/mail.php">
                    <div class="form-group">
                        <input type="text" name="name" placeholder="Name" required="required">
                    </div>
                    <div class="form-group">
                        <input type="email" name="email" placeholder="Email" required="required">
                    </div>
                    <div class="form-group">
                        <input type="text" name="subject" placeholder="Subject" required="required">
                    </div>
                    <div class="form-group">
                        <textarea name="message" rows="6" placeholder="Message" ></textarea>
                    </div>
                    <div class="form-group">
                        <button type="submit" class="button primary"><i class="fa fa-send"></i>Submit</button>
                    </div>
                </form>
            </div>
            <!--/ End Contact Form -->
        </div>
    </div>
    <div class="gmap">
        <div class="map"></div>
    </div>
</section>
<!--/ End Clients Us -->

<!-- Location -->
<section id="location" class="section">
    <div class="container">
        <div class="row">
            <div class="col-md-12 col-sm-12 col-xs-12 wow fadeIn">
                <div class="section-title center">
                    <h2>Our <span>Location</span></h2>
                    <p>Coordinates for abs potioning the closest positioned parent box of the positioned abs qoning the closes for abs potioning the closest positioned parent.</p>
                </div>
            </div>
        </div>
        <div class="row">
            <div class="col-md-4 col-sm-4 col-xs-12 wow fadeIn" data-wow-delay="0.4s">
                <!-- Single Address -->
                <div class="single-address">
                    <i class="fa fa-phone"></i>
                    <h4>Our Phone</h4>
                    <p>+8801812345678, +8801700000123</p>
                </div>
                <!--/ End Single Address -->
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12 wow fadeIn" data-wow-delay="0.6s">
                <!-- Single Address -->
                <div class="single-address active">
                    <i class="fa fa-phone"></i>
                    <h4>Office Location</h4>
                    <p>240, Khilgaon Dhaka 1230.</p>
                </div>
                <!--/ End Single Address -->
            </div>
            <div class="col-md-4 col-sm-4 col-xs-12 wow fadeIn" data-wow-delay="0.8s">
                <!-- Single Address -->
                <div class="single-address">
                    <i class="fa fa-phone"></i>
                    <h4>Corporate Email</h4>
                    <p>info@Bizpro.com, support@Bizpro.com</p>
                </div>
                <!--/ End Single Address -->
            </div>

        </div>
    </div>
</section>
<!--/ End Location -->

<!-- Newslatter -->
<div id="newslatter" class="wow fadeIn">
    <div class="container">
        <div class="row">
            <div class="col-md-6 col-sm-6 col-xs-12">
                <h2>Signup Newslatter</h2>
                <p>Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry'sstandard dummy text</p>
            </div>
            <div class="col-md-6 col-sm-6 col-xs-12">
                <div class="newslatter">
                    <form>
                        <input type="email" placeholder="type your email">
                        <button type="submit" class="button primary"><i class="fa fa-paper-plane"></i></button>
                    </form>
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ End Newslatter -->

<!-- Start Clients -->
<div id="clients" class="section wow fadeIn">
    <div class="container">
        <div class="row">
            <div class="col-md-12">
                <div class="clients-carousel">
                    <!-- Single Clients -->
                    <div class="single-client">
                        <img src="${ctx}/images/client1.png" alt="" class="img-responsive">
                    </div>
                    <!--/ Single Clients -->
                    <!-- Single Clients -->
                    <div class="single-client">
                        <img src="${ctx}/images/client2.png" alt="" class="img-responsive">
                    </div>
                    <!--/ Single Clients -->
                    <!-- Single Clients -->
                    <div class="single-client">
                        <img src="${ctx}/images/client3.png" alt="" class="img-responsive">
                    </div>
                    <!--/ Single Clients -->
                    <!-- Single Clients -->
                    <div class="single-client">
                        <img src="${ctx}/images/client4.png" alt="" class="img-responsive">
                    </div>
                    <!--/ Single Clients -->
                    <!-- Single Clients -->
                    <div class="single-client">
                        <img src="${ctx}/images/client5.png" alt="" class="img-responsive">
                    </div>
                    <!--/ Single Clients -->
                    <!-- Single Clients -->
                    <div class="single-client">
                        <img src="${ctx}/images/client6.png" alt="" class="img-responsive">
                    </div>
                    <!--/ Single Clients -->
                </div>
            </div>
        </div>
    </div>
</div>
<!--/ End Clients -->

<!-- Start Footer -->
<footer id="footer" class="wow fadeIn">
    <!-- Footer Top -->
    <div class="footer-top">
        <div class="container">
            <div class="row">
                <div class="col-md-12 col-sm-12 col-xs-12 ">
                    <!-- Logo -->
                    <div class="logo">
                        <a href="index.html"><span>Biz</span>Pro</a>
                    </div>
                    <!--/ End Logo -->
                    <!-- Social -->
                    <ul class="social">
                        <li class="active"><a href="#"><i class="fa fa-facebook"></i></a></li>
                        <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                        <li><a href="#"><i class="fa fa-linkedin"></i></a></li>
                        <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                    </ul>
                    <!--/ End Social -->
                    <!-- Menu -->
                    <ul class="nav">
                        <li><a href="index.html">Home</a></li>
                        <li><a href="portfolio.html">Portfolio</a></li>
                        <li><a href="blog.html">Latest Blog</a></li>
                        <li><a href="#">Contact</a></li>
                    </ul>
                    <!--/ End Menu -->
                </div>
            </div>
        </div>
    </div>
    <!--/ End Footer Top -->

    <!-- Copyright -->
    <%--<div class="copyright">--%>
        <%--<div class="container">--%>
            <%--<div class="row">--%>
                <%--<div class="col-md-12 col-sm-12 col-xs-12">--%>
                    <%--<div class="text">--%>
                        <%--<p>&copy; Copyright 2018<span><i class="fa fa-heart"></i></span>More Templates <a href="http://www.cssmoban.com/" target="_blank" title="模板之家">模板之家</a> - Collect from <a href="http://www.cssmoban.com/" title="网页模板" target="_blank">网页模板</a> (Distributor)</p>--%>
                    <%--</div>--%>
                <%--</div>--%>
            <%--</div>--%>
        <%--</div>--%>
    <%--</div>--%>
    <!--/ End Copyright -->
</footer>
<!--/ End Footer -->

<!-- Jquery JS -->
<script type="text/javascript" src="${ctx}/js/jquery.min.js"></script>

<!-- Colors JS -->
<script type="text/javascript" src="${ctx}/js/colors.js"></script>

<!-- Google Map JS -->
<script  type="text/javascript" src="${ctx}/js/gmap.js"></script>

<!-- Modernizr JS -->
<script type="text/javascript"  src="${ctx}/js/modernizr.min.js"></script>

<!-- Appear JS-->
<script  type="text/javascript" src="${ctx}/js/jquery.appear.js"></script>

<!-- Animate JS -->
<script  type="text/javascript" src="${ctx}/js/wow.min.js"></script>

<!-- Onepage Nav JS -->
<script  type="text/javascript" src="${ctx}/js/jquery.nav.js"></script>

<!-- Yt Player -->
<script  type="text/javascript" src="${ctx}/js/ytplayer.min.js"></script>

<!-- Popup JS -->
<script type="text/javascript"  src="${ctx}/js/jquery.magnific-popup.min.js"></script>

<!-- Typed JS -->
<script  type="text/javascript" src="${ctx}/js/typed.min.js"></script>

<!-- Scroll Up JS -->
<script  type="text/javascript" src="${ctx}/js/jquery.scrollUp.min.js"></script>

<!-- Slick Nav JS -->
<script  type="text/javascript" src="${ctx}/js/jquery.slicknav.min.js"></script>

<!-- Counterup JS -->
<script  type="text/javascript" src="${ctx}/js/waypoints.min.js"></script>
<script  type="text/javascript" src="${ctx}/js/jquery.counterup.min.js"></script>

<!-- Owl Carousel JS -->
<script  type="text/javascript" src="${ctx}/js/owl.carousel.min.js"></script>

<!-- Bootstrap JS -->
<script  type="text/javascript" src="${ctx}/js/bootstrap.min.js"></script>

<!-- Main JS -->
<script type="text/javascript"  src="${ctx}/js/main.js"></script>
</body>
</html>