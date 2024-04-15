import { useOktaAuth } from "@okta/okta-react";
import { useEffect, useState } from "react";
import { SpinnerLoading } from "../Utils/SpinnerLoading";

export const PaymentPage = () => {
  const { authState } = useOktaAuth();
  const [httpError, setHttpError] = useState(false);
  const [submitDisabled, setSubmitDisabled] = useState(false);
  const [fees, setFees] = useState(0);
  const [loadingFees, setLoadingFees] = useState(true);

  if (loadingFees) {
    return <SpinnerLoading />;
  }

  if (httpError) {
    return (
      <div className="container m-5">
        <p>{httpError}</p>
      </div>
    );
  }
  return {};
};
