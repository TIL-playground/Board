package module.board.common.http;

public enum HttpStatusUtil {
    // 1xx Informational
    CONTINUE(100, "계속 진행하십시오."),
    SWITCHING_PROTOCOLS(101, "프로토콜을 전환합니다."),
    PROCESSING(102, "요청을 처리 중입니다."),

    // 2xx Success
    OK(200, "요청이 성공적으로 처리되었습니다."),
    CREATED(201, "새 리소스가 생성되었습니다."),
    ACCEPTED(202, "요청이 접수되었습니다."),
    NON_AUTHORITATIVE_INFORMATION(203, "신뢰할 수 없는 정보입니다."),
    NO_CONTENT(204, "콘텐츠가 없습니다."),
    RESET_CONTENT(205, "콘텐츠를 재설정하십시오."),
    PARTIAL_CONTENT(206, "일부 콘텐츠만 제공됩니다."),

    // 3xx Redirection
    MULTIPLE_CHOICES(300, "여러 선택 항목이 있습니다."),
    MOVED_PERMANENTLY(301, "리소스가 영구적으로 이동되었습니다."),
    FOUND(302, "리소스를 찾았습니다."),
    SEE_OTHER(303, "다른 위치를 참조하십시오."),
    NOT_MODIFIED(304, "리소스가 수정되지 않았습니다."),
    USE_PROXY(305, "프록시를 사용하십시오."),
    TEMPORARY_REDIRECT(307, "임시로 리다이렉션됩니다."),
    PERMANENT_REDIRECT(308, "영구적으로 리다이렉션됩니다."),

    // 4xx Client Error
    BAD_REQUEST(400, "잘못된 요청입니다."),
    UNAUTHORIZED(401, "인증이 필요합니다."),
    PAYMENT_REQUIRED(402, "결제가 필요합니다."),
    FORBIDDEN(403, "접근이 금지되었습니다."),
    NOT_FOUND(404, "리소스를 찾을 수 없습니다."),
    METHOD_NOT_ALLOWED(405, "허용되지 않는 메소드입니다."),
    NOT_ACCEPTABLE(406, "요청을 수락할 수 없습니다."),
    PROXY_AUTHENTICATION_REQUIRED(407, "프록시 인증이 필요합니다."),
    REQUEST_TIMEOUT(408, "요청 시간이 초과되었습니다."),
    CONFLICT(409, "요청이 현재 서버의 상태와 충돌합니다."),
    GONE(410, "리소스가 영구적으로 삭제되었습니다."),
    LENGTH_REQUIRED(411, "요청의 Content-Length가 필요합니다."),
    PRECONDITION_FAILED(412, "전제 조건이 실패했습니다."),
    PAYLOAD_TOO_LARGE(413, "요청 본문이 너무 큽니다."),
    URI_TOO_LONG(414, "요청 URI가 너무 깁니다."),
    UNSUPPORTED_MEDIA_TYPE(415, "지원되지 않는 미디어 유형입니다."),
    RANGE_NOT_SATISFIABLE(416, "요청한 범위가 만족되지 않습니다."),
    EXPECTATION_FAILED(417, "서버가 Expect 요청 헤더를 충족할 수 없습니다."),
    I_AM_A_TEAPOT(418, "서버가 커피를 제공할 수 없습니다."),
    UNPROCESSABLE_ENTITY(422, "요청을 처리할 수 없습니다."),
    LOCKED(423, "리소스가 잠겨 있습니다."),
    FAILED_DEPENDENCY(424, "이전 요청의 실패로 인해 현재 요청이 실패했습니다."),
    TOO_EARLY(425, "요청이 너무 일찍 도착했습니다."),
    UPGRADE_REQUIRED(426, "프로토콜 업그레이드가 필요합니다."),
    PRECONDITION_REQUIRED(428, "전제 조건이 필요합니다."),
    TOO_MANY_REQUESTS(429, "요청이 너무 많습니다."),
    REQUEST_HEADER_FIELDS_TOO_LARGE(431, "요청 헤더 필드가 너무 큽니다."),
    UNAVAILABLE_FOR_LEGAL_REASONS(451, "법적 사유로 이용할 수 없습니다."),

    // 5xx Server Error
    INTERNAL_SERVER_ERROR(500, "내부 서버 오류가 발생했습니다."),
    NOT_IMPLEMENTED(501, "요청한 기능이 구현되지 않았습니다."),
    BAD_GATEWAY(502, "게이트웨이 오류가 발생했습니다."),
    SERVICE_UNAVAILABLE(503, "서비스를 사용할 수 없습니다."),
    GATEWAY_TIMEOUT(504, "게이트웨이 시간이 초과되었습니다."),
    HTTP_VERSION_NOT_SUPPORTED(505, "HTTP 버전이 지원되지 않습니다."),
    VARIANT_ALSO_NEGOTIATES(506, "서버에 내부 구성 오류가 있습니다."),
    INSUFFICIENT_STORAGE(507, "서버에 저장 공간이 부족합니다."),
    LOOP_DETECTED(508, "서버가 요청을 처리하는 동안 무한 루프를 감지했습니다."),
    NOT_EXTENDED(510, "서버가 요청을 이행하기 위해 추가 확장이 필요합니다."),
    NETWORK_AUTHENTICATION_REQUIRED(511, "네트워크 인증이 필요합니다.");

    private final int code0;
    private final String message0;

    HttpStatusUtil(final int code, final String message) {
        this.code0 = code;
        this.message0 = message;
    }

    public int code() {
        return code0;
    }

    public String message() {
        return message0;
    }
}