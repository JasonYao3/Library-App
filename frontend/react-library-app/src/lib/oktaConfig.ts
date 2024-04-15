export const oktaConfig = {
  clientId: "<client-id>",
  issuer: "https://<dev-id>.okta.com",
  redirectUri: "http://localhost:3000/login/callback",
  scopes: ["openid", "profile", "email"],
  pkce: true,
  disableHttpsCheck: true,
};
