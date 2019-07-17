--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2019-07-17 14:41:16

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- TOC entry 2866 (class 1262 OID 16393)
-- Name: rettiwt; Type: DATABASE; Schema: -; Owner: postgres
--

CREATE DATABASE rettiwt WITH TEMPLATE = template0 ENCODING = 'UTF8' LC_COLLATE = 'English_United States.1251' LC_CTYPE = 'English_United States.1251';


ALTER DATABASE rettiwt OWNER TO postgres;

\connect rettiwt

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

SET default_tablespace = '';

SET default_with_oids = false;

--
-- TOC entry 196 (class 1259 OID 16394)
-- Name: account; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.account (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    email character varying(100) NOT NULL,
    password character varying(50) NOT NULL,
    phone character varying(30),
    deleted boolean DEFAULT false NOT NULL
);


ALTER TABLE public.account OWNER TO postgres;

--
-- TOC entry 199 (class 1259 OID 16403)
-- Name: account_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.account_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.account_id_seq OWNER TO postgres;

--
-- TOC entry 2867 (class 0 OID 0)
-- Dependencies: 199
-- Name: account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;


--
-- TOC entry 202 (class 1259 OID 16466)
-- Name: comment; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.comment (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    profile_id bigint NOT NULL,
    post_id bigint NOT NULL,
    message character varying(350) NOT NULL,
    likes integer DEFAULT 0 NOT NULL,
    dislikes integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.comment OWNER TO postgres;

--
-- TOC entry 203 (class 1259 OID 16469)
-- Name: comment_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.comment_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.comment_id_seq OWNER TO postgres;

--
-- TOC entry 2868 (class 0 OID 0)
-- Dependencies: 203
-- Name: comment_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.comment_id_seq OWNED BY public.comment.id;


--
-- TOC entry 198 (class 1259 OID 16400)
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.post (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    profile_id bigint NOT NULL,
    message character varying(350) NOT NULL,
    likes integer DEFAULT 0 NOT NULL,
    dislikes integer DEFAULT 0 NOT NULL
);


ALTER TABLE public.post OWNER TO postgres;

--
-- TOC entry 200 (class 1259 OID 16426)
-- Name: post_id_seq; Type: SEQUENCE; Schema: public; Owner: postgres
--

CREATE SEQUENCE public.post_id_seq
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE public.post_id_seq OWNER TO postgres;

--
-- TOC entry 2869 (class 0 OID 0)
-- Dependencies: 200
-- Name: post_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.post_id_seq OWNED BY public.post.id;


--
-- TOC entry 197 (class 1259 OID 16397)
-- Name: profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profile (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    first_name character varying(100) NOT NULL,
    last_name character varying(100) NOT NULL,
    nickname character varying(100) NOT NULL,
    description character varying(200),
    location character varying(100)
);


ALTER TABLE public.profile OWNER TO postgres;

--
-- TOC entry 201 (class 1259 OID 16451)
-- Name: profile_2_subscriber; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.profile_2_subscriber (
    profile_id bigint NOT NULL,
    subscriber_id bigint NOT NULL
);


ALTER TABLE public.profile_2_subscriber OWNER TO postgres;

--
-- TOC entry 2706 (class 2604 OID 16405)
-- Name: account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account ALTER COLUMN id SET DEFAULT nextval('public.account_id_seq'::regclass);


--
-- TOC entry 2711 (class 2604 OID 16471)
-- Name: comment id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment ALTER COLUMN id SET DEFAULT nextval('public.comment_id_seq'::regclass);


--
-- TOC entry 2708 (class 2604 OID 16428)
-- Name: post id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post ALTER COLUMN id SET DEFAULT nextval('public.post_id_seq'::regclass);


--
-- TOC entry 2853 (class 0 OID 16394)
-- Dependencies: 196
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.account (id, created_at, updated_at, email, password, phone, deleted) VALUES (1, '2019-07-16 17:18:35.465', '2019-07-16 17:18:35.465', 'new@mail', 'newPsw', NULL, false);


--
-- TOC entry 2859 (class 0 OID 16466)
-- Dependencies: 202
-- Data for Name: comment; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.comment (id, created_at, updated_at, profile_id, post_id, message, likes, dislikes) VALUES (1, '2019-07-17 14:02:39.821344', '2019-07-17 14:02:39.821344', 1, 4, 'comment 1 under post 4', 0, 0);
INSERT INTO public.comment (id, created_at, updated_at, profile_id, post_id, message, likes, dislikes) VALUES (2, '2019-07-17 14:02:48.621007', '2019-07-17 14:02:48.621007', 1, 4, 'comment 2 under post 4', 0, 0);


--
-- TOC entry 2855 (class 0 OID 16400)
-- Dependencies: 198
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.post (id, created_at, updated_at, profile_id, message, likes, dislikes) VALUES (4, '2019-07-17 14:02:17.085827', '2019-07-17 14:02:17.085827', 1, 'post with id = 4', 0, 0);


--
-- TOC entry 2854 (class 0 OID 16397)
-- Dependencies: 197
-- Data for Name: profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.profile (id, created_at, updated_at, first_name, last_name, nickname, description, location) VALUES (1, '2019-07-16 17:18:35.465', '2019-07-16 17:18:35.465', 'Eugene', 'Mikh', '@eugene_mikh', NULL, 'Grodno, BY');


--
-- TOC entry 2858 (class 0 OID 16451)
-- Dependencies: 201
-- Data for Name: profile_2_subscriber; Type: TABLE DATA; Schema: public; Owner: postgres
--



--
-- TOC entry 2870 (class 0 OID 0)
-- Dependencies: 199
-- Name: account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_id_seq', 1, true);


--
-- TOC entry 2871 (class 0 OID 0)
-- Dependencies: 203
-- Name: comment_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.comment_id_seq', 2, true);


--
-- TOC entry 2872 (class 0 OID 0)
-- Dependencies: 200
-- Name: post_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.post_id_seq', 4, true);


--
-- TOC entry 2715 (class 2606 OID 16413)
-- Name: account account_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_email_key UNIQUE (email);


--
-- TOC entry 2717 (class 2606 OID 16411)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 2725 (class 2606 OID 16478)
-- Name: comment comment_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_pkey PRIMARY KEY (id);


--
-- TOC entry 2723 (class 2606 OID 16435)
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);


--
-- TOC entry 2719 (class 2606 OID 16425)
-- Name: profile profile_nickname_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_nickname_key UNIQUE (nickname);


--
-- TOC entry 2721 (class 2606 OID 16418)
-- Name: profile profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (id);


--
-- TOC entry 2731 (class 2606 OID 16484)
-- Name: comment comment_post_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_post_id_fkey FOREIGN KEY (post_id) REFERENCES public.post(id);


--
-- TOC entry 2730 (class 2606 OID 16479)
-- Name: comment comment_profile_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.comment
    ADD CONSTRAINT comment_profile_id_fkey FOREIGN KEY (profile_id) REFERENCES public.profile(id);


--
-- TOC entry 2727 (class 2606 OID 16441)
-- Name: post post_profile_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_profile_id_fkey FOREIGN KEY (profile_id) REFERENCES public.profile(id);


--
-- TOC entry 2728 (class 2606 OID 16454)
-- Name: profile_2_subscriber profile_2_subscriber_profile_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_2_subscriber
    ADD CONSTRAINT profile_2_subscriber_profile_id_fkey FOREIGN KEY (profile_id) REFERENCES public.profile(id);


--
-- TOC entry 2729 (class 2606 OID 16459)
-- Name: profile_2_subscriber profile_2_subscriber_subscriber_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_2_subscriber
    ADD CONSTRAINT profile_2_subscriber_subscriber_id_fkey FOREIGN KEY (subscriber_id) REFERENCES public.profile(id);


--
-- TOC entry 2726 (class 2606 OID 16419)
-- Name: profile profile_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_id_fkey FOREIGN KEY (id) REFERENCES public.account(id);


-- Completed on 2019-07-17 14:41:16

--
-- PostgreSQL database dump complete
--

