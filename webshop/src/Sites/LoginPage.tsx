
import '../CSS/LoginPage.css';
import {Formik} from "formik";
import {useNavigate} from "react-router-dom";
import {LoginService} from "../services/LoginService";

export default function LoginPage(){
    const navigate = useNavigate();
    async function login(email: string, password: string) {
        LoginService()
            .login(email, password)
            .then((respone) => {
                if(respone == false){
                    console.log(false);
                }else{
                    navigate("/home", { replace: true });
                }
            })
            .catch((error) => {
                console.log(error);
            });
        return true;
    }
    return(
        <div className="loginPage">
            <h3 className="loginTitle">Login</h3>
            <div className="f1">
                <div className="f2">
                    <Formik
                        initialValues={{ email: "", password: "" }}
                        // begin validation
                        validate={(values) => {
                            const errors: { [field: string]: string } = {};
                            //check email
                            if (!values.email) {
                                errors.email = "Email Required";
                            } else if (
                                !/^[A-Z0-9._%+-]+@[A-Z0-9.-]+\.[A-Z]{2,}$/i.test(values.email)
                            ) {
                                errors.email = "Invalid email address";
                            }

                            //check password
                            if (!values.password) {
                                errors.password = "Required";
                            }
                            return errors;
                        }}
                        // end validation
                        onSubmit={(values, { setSubmitting }) => {
                            const token = login(values.email, values.password);
                            setTimeout(() => {
                                alert(JSON.stringify(values, null, 2));
                                navigate("/home");
                            }, 400);

                            {
                                /*<Link to="/Home"/>*/
                            }
                        }}
                    >
                        {({ isSubmitting }) => (
                            <Form>

                                <label>Email</label>
                                <Field type="email" name="email" />
                                <ErrorMessage
                                    name="email"
                                    component="div"
                                    className="Errormessage"
                                />
                                <label>Password</label>
                                <Field type="password" name="password" />
                                <ErrorMessage
                                    name="password"
                                    component="div"
                                    className="Errormessage"
                                />
                                <button className="button-login" type="submit" disabled={isSubmitting}>
                                    Submit
                                </button>
                            </Form>
                        )}
                    </Formik>
                </div>
            </div>
        </div>
    );
}