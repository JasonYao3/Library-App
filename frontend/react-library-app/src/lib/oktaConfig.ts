export const oktaConfig = {
  clientId: "0oaa7zoamhptuPXv05d7",
  issuer: "https://dev-57743006.okta.com/oauth2/default",
  redirectUri: "http://localhost:3000/login/callback",
  scopes: ["openid", "profile", "email"],
  pkce: true,
  disableHttpsCheck: true,
};
