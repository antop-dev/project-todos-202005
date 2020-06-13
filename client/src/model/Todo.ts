/**
 * 할 일 모델
 */
export interface Todo {
    id: string,
    /**
     * 제목
     */
    title: string,
    /**
     * 완료 여부
     */
    done: boolean
}
