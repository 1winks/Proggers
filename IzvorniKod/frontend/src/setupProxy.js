const { createProxyMiddleware } = require("http-proxy-middleware");

module.exports = function (app) {
  app.use(
    "/api",
    createProxyMiddleware({
      target: "https://proggers.xyz:8080/",
      changeOrigin: true,
    })
  );
};