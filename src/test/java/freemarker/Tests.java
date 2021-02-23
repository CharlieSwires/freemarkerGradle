package freemarker;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class Tests {

    private Freemarker service = null;
    private Encryption encryption = null;
    
    private RController controller = null;

    private static final double delta = 0.00001;
    
    @Before
    public void startup() {
        service = new Freemarker();
        encryption = new Encryption();
        controller = new RController(service, encryption);
    }

    @Test
    public void test() {
        TamperedBean input = new TamperedBean();
        input.setFileB64("JVBERi0xLjQKJdPr6eEKMSAwIG9iago8PC9DcmVhdG9yIChDaHJvbWl1bSkKL1Byb2R1Y2VyIChTa2lhL1BERiBtOTApCi9DcmVhdGlvbkRhdGUgKEQ6MjAyMTAyMjEwNjUzNTkrMDAnMDAnKQovTW9kRGF0ZSAoRDoyMDIxMDIyMTA2NTM1OSswMCcwMCcpPj4KZW5kb2JqCjMgMCBvYmoKPDwvY2EgMQovQk0gL05vcm1hbD4+CmVuZG9iago1IDAgb2JqCjw8L0ZpbHRlciAvRmxhdGVEZWNvZGUKL0xlbmd0aCAxNzk+PiBzdHJlYW0KeJx1jssKwjAQRff5ilkLpjOZPBoQFy22ayXgB4gVhArW/wcniYKC5jKv5M4h2nAsB1C01h9ja0lHirGF06zuKr8bG6Im7x2ww6CDYQ/LWR1XcBMHazKeiW1hfU+CIMg6jFCb5aKakeHyKOQQGYiMybip3GC21kasXVLNYIENpElI5bMELXCANKsNokOJXhJLDYi2f9VBokUku4V0Vbv0FxXdLxTVdddVHLk3Zi96ApusP5wKZW5kc3RyZWFtCmVuZG9iagoyIDAgb2JqCjw8L1R5cGUgL1BhZ2UKL1Jlc291cmNlcyA8PC9Qcm9jU2V0IFsvUERGIC9UZXh0IC9JbWFnZUIgL0ltYWdlQyAvSW1hZ2VJXQovRXh0R1N0YXRlIDw8L0czIDMgMCBSPj4KL0ZvbnQgPDwvRjQgNCAwIFI+Pj4+Ci9NZWRpYUJveCBbMCAwIDU5NC45NTk5NiA4NDEuOTE5OThdCi9Db250ZW50cyA1IDAgUgovU3RydWN0UGFyZW50cyAwCi9QYXJlbnQgNiAwIFI+PgplbmRvYmoKNiAwIG9iago8PC9UeXBlIC9QYWdlcwovQ291bnQgMQovS2lkcyBbMiAwIFJdPj4KZW5kb2JqCjcgMCBvYmoKPDwvVHlwZSAvQ2F0YWxvZwovUGFnZXMgNiAwIFI+PgplbmRvYmoKOCAwIG9iago8PC9MZW5ndGgxIDg0MDAKL0ZpbHRlciAvRmxhdGVEZWNvZGUKL0xlbmd0aCA1NDc1Pj4gc3RyZWFtCniczTkLcBTXka/fzOxHi7Sz+qw+q2FnNRoJaSX0WQSIAbT67GpBIIQ+sBJIWoEEInwkkIzBjmM5F9tYGEMSh5j4ciZ3roQYx4wwsUWSsxUbU+UkTqjD9sUJxCTnyp3L6KAc22UT0F6/2RUI26ncr67uzc573f26+3X36/eZWgKEEDsZIRwZDAZbV278+SstSLmOb/aqlpLy+84cWUsIZCAe2bi9Z5Cz0rsQ34P4to27h2X/jqWPI/4OIdS0aXDz9qHzik4Id5kQs7C5Z2iQpBIrIQkfIL+4edveTVfOfPshQmwfE5L0Qn9fT+8HDRdUxCewf34/EpJOmcoJyRpHPLd/+/CevLN0EPELOMaubQMbexZ8azF22XisfrK9Z8+goJh+j6Y2IS7v6Nnep37P/y7iKANXBweGhqO55GVCZkdY/+CuvsFvfvkHdYiPoL0rkca8J29MBth45EVXz1XW/vJl6SnC8T+lPyECIcK3BB8yqrGWO0o20WQQKLVwZkGgHLOEIzNKWXVLLZHxOSpsnQqCz+yBH+PwT7z9z8j4tLCEWUIo1jQumYo1GC1PwtgmExEpFLnKSR/ZQnaQYbKXHI1GDckyg7YNaXsYLfovtz0bYx7dXoQDJI0M4Mj2eH1b4Z4mmeQkIdHLDLtVT62IXvusrv9+sRg1JIOHvEI+AR9Q8kVIIR2klwyQL5JR8M3kBg1WYN895AL27yAHwPz5WsEDeZCIGjoMvnvIa+QPn8u4k7xArt4+BtIOkyfJ04wOQdT1KLwMK6AXdTDNK7Ba/3mq6BewOojvHqy303jE6RXyC/Jrsp6+QN8hh8gzcfuSyGXAjIMGtPD5uIIG0vIZpeNoRQLZjDP9AEobRVhy/TfEGv0T6lpOfoqEZeRucuCmxMdgjMElkOhN2tqbNvbS/ZACeeTvyMekTnDAKUL8gfZwW2tL8+qmVY0rVzQsXxaqDwbqamuq/VVLlyzWFlUuXDC/oqy0ZG5x0Zz8PDVXyfG4M1Idoj0p0ZZgtZhNAs+ht0UBJRiR9byIzucpoVAxw5UeJPTMIER0GUnB23l0OWKwybdz+pFz06c4/TFO/01OEOXFZHFxkRxQZP21OkUeh47VYYQP1Cntsj5pwCsNmM8zkEREPB6UkAMZ/XWyDhE5oAd3948GInWob8yWUKvU9iUUF5GxBBuCNoT0OcrgGMxZCgZA5wQWjVFiSWTD6pwa6OnVm1aHA3Uuj6e9uGiZnqTUGV2k1lCpm2p1s6FS3sJMJ/vlsaKJ0YfHRbIh4p3Vq/T2rA/rXA/KjnKB0dEHdYdXL1Dq9IK73slAz/v0IqUuoHuZ1obmm+M03BoSdEEVFXn0Q4LuKJOXb6f0xCkmVfyQMDCI4R0dDSpycDQy2jMeHdmgyKIyOjZr1uhgACNMmsIoNR790X6XHny4XRcj/bAo7mywuUFPWb0urFM1KPf3IAV/VYpnocvjaJ/mafpL3QQDgeHAmHo8zPH9436yARF9ZHU4hstkg+sk8Zd423UaYT0T0z1pbaxnZLrnpnhEwdlsaAmP6ry6rFcJYIz39+gjGzCfvsCmQhH1pI9cHmU02SFXlrQbvDJatax3i6wLeRgWlJopgJnCREZFA0n6KNZMunCAPEeyXKmgGqYnoAQi8d/u/gxUIBcX6SFvbOpbw7q/DgF/T3yOAmOlJSjRE8Ep2lJnTJ9eogzqqUrNzflkZgW2tIQNkbiYnlqr4yEbl9JLAnVsZDkwGqmLmcB0KavDp4kvemlsnux61kfmkfY6xuysxbzKC4yGezfp7oirF1faJjns8uj+dpzgdiXc184SDSNUcAmH8xgj6rS2NdzQojSs7ggvjBsS62DqeDXwKTVK2BVTgymnW1SLHKYurh0ZRSTIQQSUmsVY62bVgq+IATeoLFVrFsthcJFpbjRDL5ADfXVxPobfplRg6VQbmtZmYijqqQ25PO2eWCkuotgtxwdGCQsLami6i1NxJ0AaRTUGicUyg+W8HFb6lHalX9b9TWHmGwuPEeV4MIyYx+eq9TZsRrAwTMSD3dMIC6Ye9LpmBlevN/CbaOhT3cumu+VRi9LQMsqUK3GFBC1fphOWwv6FDpex+tl6VoI9uIhxRRvreXTM72druZ8t21FlWe+o0hJebHDjDnKP6y42VjJpgIbWmuIi3MxqxhTYt3rMD/taOsKnRbxS7GsNn6RAayM17WO52Bc+LeNZYVApozIiQ2SGME3NiFgMftdpPyEjRi9vEAx84zgQg2aZpgHZOE5jNHGaRpHGx2h+g8YKzlJGP8YY9++A3Mvm54vt/aORdpbjxIkRwR/ooCzF6ChLx4CaZukJSl+NblNqGL2K0atidBOjmzEzwAnFRXeNigHlw4zi2PHI4XWEkkQCeKtidzDvf/JZj+fw/8GD95HY823j+QN3ll8z4zkee0xp5m7jvgeO97r2nXy32774Q+KO3bNm3mWn9t/4uuUZi4i8FuPWaVwQSB27JQht6L+ZzB0DUrL4pJknk+VjJuHC4pMcRZCMcYwsMPJJswmuLz4JjO5zeByqx+Gpo/JULjw21S+0XTtex7+GIzyJwT0shEgCmeeXyY6DAhBBFPxCk8ALJquFmEUzNZutJiIMcxmkarK8ylfS6UuuhJLOzsmyUjU9zVOxwGGuUH30B+/eSPq3f4W7HtmRsWZNBvenFW2/Yzf2NTjCMWEFySF9fr/FAftssMkE9aa1JjrfBMkpOTlZO6z+K9aolRKraKUp1hRrrqcUs6yJHsI8tXqSR5KG0s3UcycwCyqrJrN+YRiAZuCG39mZJU6Wlzh8ZaWdrBRAxVKhYt5cquSY7KA4loKv3JmWmsSbPdyx68+s+dqd65fIckUwf+lyt3dt05GOi+/lLdt24Ole+rV/XP/Ve3buHQ0vWbdkdlbWS1CWnPncsab7dm3b83A7zkAwOsmFuZeJROaQ7f7GOzMfzKS7bQ/YqD3XnUtF8ZAJTEE5tzTXn3s0V8+dyDXl5haWFFYVdhcOFN5beKLwxcJfFV4ptCrm+nMucJlW5eYSR+Jqp3P2KvyGqJqsuvFacmXJJHo2Wd6JUOdkZ3lJJ3MLymdTCTxpqbOpr3z+grQkTsmZSyvmzU/PSaJpPnQW/r3lgS7fVIqtrK9dG/SlB1vWF+99env5+Z/lznUl/EZImcO9PKfnO3ubxdq7uxcm21YmZacl+r80vuej9/sKV+yord2xopBlGS446sIvECt6Oexfnbq8KeFQAj2XAAlmPoMHPh0ASD3LkXMCJwiz3X53k5tG3Efduptzu0F3T7gvubkSd5X7oJuzZ7ozaWaLnZgarXYiNHJpRgpNVk12Qmfnzp27HIab5Z2+Tofv9Z27bmVUfoUH5i1Fb2dTnDvK3IVTm6eSN0Xgvqk3MgoXyvLCgoyMAtYWZnRk1NRk0I8zaiA0k4xsLAPnoE9Ow6duv3KEwhGA9Nu8SLD5bU02GrEdtek2zjYenfBLZfNCbhvotgnbJRtXYquyHbRxpkZcrbe8YC54p33Aadq1a4bxJ+LGGqbxb2XUMEsWEGJ6kHuFVHIe/4oF5fXldEFZfRndkr83ny7MD+WH87kteXvz6MK8UF44j8tXF6j1KpefuyC3Ppfbkr43naZbbEmhLc69Tupk0Bpxk7hb5MTx6CV/1JoYWmPeZN5t5jiLSXEq1KrUz5lTkVFfmQKmFGcKdaZoeRpkamDT4NqfNfijBqe1VzX6XQ00/5U/hRo0sGoFWqXGvaV9otEzGjynwRZtr3ZE49YwwQJtmca9qr2r0R9r8H0NHtfgIQ3u1mCTBpUaeJl8pkZ/9q4Gv9XgNQ2Q7QHtsEaZEtqgrdNoJRvr1HgINTO9dKsGnRo0GGa9y0a9yEY9q9EjyDjyt0dDhsbH0Noz2jsaPax9V3tO476iwW5mGrRqUKPBPA3yNH8UeA1OaWe01zVuN/LRDUZ/njZfC2oc+vyO9gFz9qz2psYdYZZhd682rHFBY3iU7n+fcQHjoI8ytx4wLDZh3CjS32T6AcMVG79XAwxLrjZPo04jmi9N9zN/HzKCVqfB/HhYFqKGf9IAJjR4Ujul0f0aRJh4ndZ6y7xzzFHQNTiuwSCzqQ5N5F7XmBRt0ga1EU3X+CoNiAYWUlpPKsSKiYpzFXzFfH9G40J76RwlI6WiUXX60rKbLYliUTOmOanyTRo/32Q5K1WxTaYLt8tutg6Nssso3bt2dXVOl503S6zzVtdt1FiP9xbdu+vT/LckvNN08QLWkw7c8bo6y8tKu1GBN6bEKLCUw407ndW4BzhiK2teHu7q5tlwO+64texOupc3ry1uHJ4tt6yLFFV21eZ2TRW3VtfktuULQgxUV6prporXr4ftXIeYJ6dVVqd4czNm13yh4cZTxj5S0tqVnpJW5rqFOh03gtNbTHwd8624jmXyo9PEEj3nl6xi6EjS95NOJ3FJ8iwxlMTbwGqr58VUkWaJbEPZmJAYEsWc3BxYlwN8TmoOrRzO+UrOmZzXc/imHKClOf4c2pQTydFzLuVczRHcOTCYcxSxiRy+JAfmZdbhTkrS60m2mD2RfS6bz5Ya3fZ00ZbdmJWWlJZ6c5qrJm9NcLkR9/ic7sR9ytvVidH2efFU8cJnQ/vpSIaLKyOBPBa2+poVK26L2u3xyrlRPTM+nuhl+h3+PuIia/2V/Rws4pZzHRxn41ycl+OIE5qc4HTOEuutI7ELh4wbMS8I2ZLJvspmnWVPT1lNnLjL+qp8r02WO5IBt9idLHmxMc55gZ1/DqWiCnxpvjTFkeqMH4zwXMPWOvnur95x+OzZ+UU5tVLS/Or61NyqtT66tTr/jTf6b3yvuibB1JaQak8wbliE+5B7mrjooD8qOCucAWebkxfSKtICaW1pfGEK7Enel0wTHIWORY7lDj5BLBQXictFPsGyyLLc0mHhE8yLzMvNHWZeFeBOHgRO5Sq4AMcLVKUVNEB5IdM0K9WWyCdmZZpSUm3JruRZ2KQKiBJe5Kk92Z1MrSZoRmJjpik1M9OUDM18Ir/SlZzqciWbbMIsFE5xJScvT4REiR/Ey0NqIBM4PhNsma0SlEqQKuVK9Lj0c+k9iXtUAq/UIFFegg8ksEleSUN0v3QcO82/RtKEdE6ij0qnJLo1JjlP4pDsH/y5BK3SsPQV7OJtTAUSGEKZkq0Sd2yroYSruzUm435U+kDimySgdgnelq5IVJaaJF3iEN19VYKD0hPSCYnzI5Ea3UQSJYodElsYKe3rQwMxDkaXJa4G6SP+7CXVIVliQiPSIWlCMvkROIrAJUlggs9WLg4Zbdl8o/W7C+aG3BIQCTKTE1MbU7JmCTyIzjSbiXc1WsDOVgdbGr7k9EoG4PHt9XrxCMe14e00NjO2Le3sju1rXfE9a3ofi8MlXbhl+s7uLBcvdGJiVlay92z5g6L3Qe+ZBzOMBpD9wYkJ0XgtE5Z4XVYKnTNKSoUnzZy+IJ81VjAWXr7ZaKzgho+2PPTDLvC3TH0MhR1TCVue/E3X1EQrFE29z22trnadfyOzujpt6mdT89Oqq9NvRLEWIQLfYasvdSrIXcacVqjHPzvTDhmJkJcwP4HmWedb6VrzZjMVzGlmWieAMB69+px1VqgOb3YI+msRdgKECDjNYDabcHngZ0SzaSUqxRuTNSkziSaZkQpWgqdPophIExJVa1ZmVkEWN4vLwtQFNhXRWfYQmNQ8Nag+oJ5VBacBrlE3IfpdJPxRtZqQ8KbKnV+jHmatVS1Q6ScqvKfCafVVlR5XYa/6kEq3qrBMbVepVwWrmqlS7H9VfUulj6vHVWpwrFO3qrRArVSXqZyLccHfv6t+otLfqvB9leniHldhk7obh+ZU/9cPh2wqvKUyFu41FeC4+mOVHlQBB1qlYgarJapRrVIH1IPqCfVX6hXVssutVqnd6r3qE+qL6tuq+RYYVU2qv28wRFRR9avcghEViCr70xmCgBpRR9Sj6oR6Sb2qWswqC45TmhPCIObObspKyU60mKDRlsBzLD198QSddCAImJc7jWN1Z5eRlDuNzPR+3jlspCZjL/H6fCW+7q5O8Sweqo7KLrxX+zoxOb3iGZaEZaWE3bxvnbMCGPnnijUQ+7DIr/Clz8bPpqV0Afxyal8N/H7w4is7wFc3dUCuWd0fyC5QVedib5KSWbCk3JshcQO4+Wfd+JgmYJt6faD54c2LMMeE979km1VY311BjH9uzJ6pAFlrpVP7px6xPPOZfz7W08vsG3f6c/d/XnhCnsR3zf+Cqv8XhTtAgjNxWkmKZ8BzTE+RBfwQu5t8ttCniGcmzrM/eFJJ7B+1TmgmrWSQCBh2kZSQDhwryl82/tXCaUOcI8BbEZ4gb8ZhwLvPc3GYoq5n4jBH/GRHHOZJIc5oDBZINn6HxWAT+yIjK8gWsoH0kV2khwwjPIByLQa+hWxCz2qQso304vwx2lCcg/2jNpeUopdzybzP1SHP0CLf1FKNGjYifQfCrFfGEeT/gvx0+9ckapEySPYa2GbSjzwyeruRFBj/D5YalsukGfl7sQ0ZWooQWoZ6NqJPMlq6DR95hoYhA+vDlo2y25Cda1i/DO0KoLZqnL9lZBVpROoWg78H32HDSubvdmx3ka1IGzC8+svjx/8bjXrY/7CfLf4y6x8uVbjf9l1s+53vQlvpxaaLIxf1i/xF4NoucE73wHnoPn/lPF11HqpeAvdLb79E2Zb3DxMJicGmFyMvDr7IvVBf6CbjUPJ89/MHnz/x/NvPCwN/Bve1K9fowLV7r1H/NRj4IdhPuU/RgVPgfnbVs9FnuWeernHbj917jJ44BoPHoOoYiI/Jj5U+xg0+Bt88nO0u+UbVN+hX7+91n3gEHl7ldpP7I/fTQ/fDob+BLyMq3iHfQYcjUfdQd9Q9iOMP4LujPurO9GW0mX1cm4mLupmdJ6bm+oITG+BSD0S657m7UdZ9veT6E9e5E9eB4HHcZU0M3rv+4Pon1nPrOrzukg4gHZEOeqjjagd1d0CKL7lNwFDwqNPOubkqbhU3wB3kTJaW5R53E6obaLy38WAjt7JecS+vl914TPpDNnswiAbZ6931NDvkasNPtzYH2NtEn72NAmkDH2krsUft1G7vtt9rZ0cFoSNOEGAcDo21tni9DePmaHODbm5ap8M+XW1htX91h27ap5O2jnXhMYBH2u8/cIDUSA16eUtYj0jtDXovAn4GjCAgSmNOUtM+NDTsNQoMeb3DXoKvt2vIwIeG70BseGiYeL1DQwYPvogMA+JIHfIOIYT5ypQMwdAwA4bIEPaTIfYOI+0OJs1EM7own/4DegShRwplbmRzdHJlYW0KZW5kb2JqCjkgMCBvYmoKPDwvVHlwZSAvRm9udERlc2NyaXB0b3IKL0ZvbnROYW1lIC9MaWJlcmF0aW9uU2VyaWYtQm9sZAovRmxhZ3MgNAovQXNjZW50IDg5MS4xMTMyOAovRGVzY2VudCAtMjE2LjMwODU5Ci9TdGVtViA4My45ODQzNzUKL0NhcEhlaWdodCA2NTQuNzg1MTYKL0l0YWxpY0FuZ2xlIDAKL0ZvbnRCQm94IFstMTgyLjEyODkxIC0zMDMuMjIyNjYgMTA4NC45NjA5NCAxMDA3LjgxMjVdCi9Gb250RmlsZTIgOCAwIFI+PgplbmRvYmoKMTAgMCBvYmoKPDwvVHlwZSAvRm9udAovRm9udERlc2NyaXB0b3IgOSAwIFIKL0Jhc2VGb250IC9MaWJlcmF0aW9uU2VyaWYtQm9sZAovU3VidHlwZSAvQ0lERm9udFR5cGUyCi9DSURUb0dJRE1hcCAvSWRlbnRpdHkKL0NJRFN5c3RlbUluZm8gPDwvUmVnaXN0cnkgKEFkb2JlKQovT3JkZXJpbmcgKElkZW50aXR5KQovU3VwcGxlbWVudCAwPj4KL1cgWzAgWzM2NS4yMzQzOCAwIDAgMjUwXSAyMCAyMSA1MDAgNzIgWzQ0My44NDc2Nl0gNzYgNzkgMjc3LjgzMjAzIDgwIFs4MzMuMDA3ODEgNTU2LjE1MjM0XSA4NyBbMzMzLjAwNzgxIDAgMCAwIDUwMCA1MDBdXQovRFcgMD4+CmVuZG9iagoxMSAwIG9iago8PC9GaWx0ZXIgL0ZsYXRlRGVjb2RlCi9MZW5ndGggMjc3Pj4gc3RyZWFtCnicXZHNaoUwEIX3eYpZ3i4u/tdbEKG1XHDRH2rvA2gy2kCNIcaFb984sRYaSMKXmXMSToKqfq6VtBC8m4k3aKGXShicp8VwhA4HqVgUg5Dc7kQrH1vNAidu1tniWKt+YkUBEHy46mzNCqdHMXV4x4I3I9BINcDpVjWOm0XrbxxRWQhZWYLA3jm9tPq1HRECkp1r4erSrmen+ev4XDVCTBz51/BJ4KxbjqZVA7IidKOE4upGyVCJf/XUq7qef7WGuhPXHYZxWG6UXojuM0+VpweiLCfKU/LdHZJfv+P6KKW2KKMtibzTlSiLvGHlDZ/8ob8lv+y+3ml7+hbxkQtfjHGR0D9QFlsKUuHxVXrSm2qbPx7mjSUKZW5kc3RyZWFtCmVuZG9iago0IDAgb2JqCjw8L1R5cGUgL0ZvbnQKL1N1YnR5cGUgL1R5cGUwCi9CYXNlRm9udCAvTGliZXJhdGlvblNlcmlmLUJvbGQKL0VuY29kaW5nIC9JZGVudGl0eS1ICi9EZXNjZW5kYW50Rm9udHMgWzEwIDAgUl0KL1RvVW5pY29kZSAxMSAwIFI+PgplbmRvYmoKeHJlZgowIDEyCjAwMDAwMDAwMDAgNjU1MzUgZiAKMDAwMDAwMDAxNSAwMDAwMCBuIAowMDAwMDAwNDQwIDAwMDAwIG4gCjAwMDAwMDAxNTQgMDAwMDAgbiAKMDAwMDAwNzI0NyAwMDAwMCBuIAowMDAwMDAwMTkxIDAwMDAwIG4gCjAwMDAwMDA2NjAgMDAwMDAgbiAKMDAwMDAwMDcxNSAwMDAwMCBuIAowMDAwMDAwNzYyIDAwMDAwIG4gCjAwMDAwMDYzMjIgMDAwMDAgbiAKMDAwMDAwNjU2NyAwMDAwMCBuIAowMDAwMDA2ODk5IDAwMDAwIG4gCnRyYWlsZXIKPDwvU2l6ZSAxMgovUm9vdCA3IDAgUgovSW5mbyAxIDAgUj4+CnN0YXJ0eHJlZgo3MzkyCiUlRU9G");
        input.setSha1("wd30x/TPlfx+TO77/lzphlkuGMo=");
        Assert.assertTrue("match",controller.isTamperedWith(input).getBody().booleanValue()==false);
    }
    @Test
    public void test2() {
        TamperedBean input = new TamperedBean();
        input.setFileB64("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+hbxkQtfjHGR0D9QFlsKUuHxVXrSm2qbPx7mjSUKZW5kc3RyZWFtCmVuZG9iago0IDAgb2JqCjw8L1R5cGUgL0ZvbnQKL1N1YnR5cGUgL1R5cGUwCi9CYXNlRm9udCAvTGliZXJhdGlvblNlcmlmLUJvbGQKL0VuY29kaW5nIC9JZGVudGl0eS1ICi9EZXNjZW5kYW50Rm9udHMgWzEwIDAgUl0KL1RvVW5pY29kZSAxMSAwIFI+PgplbmRvYmoKeHJlZgowIDEyCjAwMDAwMDAwMDAgNjU1MzUgZiAKMDAwMDAwMDAxNSAwMDAwMCBuIAowMDAwMDAwNDQwIDAwMDAwIG4gCjAwMDAwMDAxNTQgMDAwMDAgbiAKMDAwMDAwNzI0NyAwMDAwMCBuIAowMDAwMDAwMTkxIDAwMDAwIG4gCjAwMDAwMDA2NjAgMDAwMDAgbiAKMDAwMDAwMDcxNSAwMDAwMCBuIAowMDAwMDAwNzYyIDAwMDAwIG4gCjAwMDAwMDYzMjIgMDAwMDAgbiAKMDAwMDAwNjU2NyAwMDAwMCBuIAowMDAwMDA2ODk5IDAwMDAwIG4gCnRyYWlsZXIKPDwvU2l6ZSAxMgovUm9vdCA3IDAgUgovSW5mbyAxIDAgUj4+CnN0YXJ0eHJlZgo3MzkyCiUlRU9G");
        input.setSha1("wd30x/TPlfx+TO77/lzphlkuGMo=");
        Assert.assertTrue("changed",controller.isTamperedWith(input).getBody().booleanValue()==true);
    }

}
