--
-- PostgreSQL database dump
--

-- Dumped from database version 11.4
-- Dumped by pg_dump version 11.4

-- Started on 2019-07-15 11:19:09

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

DROP DATABASE rettiwt;
--
-- TOC entry 2852 (class 1262 OID 16393)
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
-- TOC entry 2853 (class 0 OID 0)
-- Dependencies: 199
-- Name: account_id_seq; Type: SEQUENCE OWNED BY; Schema: public; Owner: postgres
--

ALTER SEQUENCE public.account_id_seq OWNED BY public.account.id;


--
-- TOC entry 198 (class 1259 OID 16400)
-- Name: post; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.post (
    id bigint NOT NULL,
    created_at timestamp without time zone NOT NULL,
    updated_at timestamp without time zone NOT NULL,
    post_id bigint,
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
-- TOC entry 2854 (class 0 OID 0)
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
-- TOC entry 2700 (class 2604 OID 16405)
-- Name: account id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account ALTER COLUMN id SET DEFAULT nextval('public.account_id_seq'::regclass);


--
-- TOC entry 2702 (class 2604 OID 16428)
-- Name: post id; Type: DEFAULT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post ALTER COLUMN id SET DEFAULT nextval('public.post_id_seq'::regclass);


--
-- TOC entry 2841 (class 0 OID 16394)
-- Dependencies: 196
-- Data for Name: account; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.account (id, created_at, updated_at, email, password, phone, deleted) FROM stdin;
\.


--
-- TOC entry 2843 (class 0 OID 16400)
-- Dependencies: 198
-- Data for Name: post; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.post (id, created_at, updated_at, post_id, profile_id, message, likes, dislikes) FROM stdin;
\.


--
-- TOC entry 2842 (class 0 OID 16397)
-- Dependencies: 197
-- Data for Name: profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profile (id, created_at, updated_at, first_name, last_name, nickname, description, location) FROM stdin;
\.


--
-- TOC entry 2846 (class 0 OID 16451)
-- Dependencies: 201
-- Data for Name: profile_2_subscriber; Type: TABLE DATA; Schema: public; Owner: postgres
--

COPY public.profile_2_subscriber (profile_id, subscriber_id) FROM stdin;
\.


--
-- TOC entry 2855 (class 0 OID 0)
-- Dependencies: 199
-- Name: account_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.account_id_seq', 1, false);


--
-- TOC entry 2856 (class 0 OID 0)
-- Dependencies: 200
-- Name: post_id_seq; Type: SEQUENCE SET; Schema: public; Owner: postgres
--

SELECT pg_catalog.setval('public.post_id_seq', 1, false);


--
-- TOC entry 2706 (class 2606 OID 16413)
-- Name: account account_email_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_email_key UNIQUE (email);


--
-- TOC entry 2708 (class 2606 OID 16411)
-- Name: account account_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.account
    ADD CONSTRAINT account_pkey PRIMARY KEY (id);


--
-- TOC entry 2714 (class 2606 OID 16435)
-- Name: post post_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_pkey PRIMARY KEY (id);


--
-- TOC entry 2710 (class 2606 OID 16425)
-- Name: profile profile_nickname_key; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_nickname_key UNIQUE (nickname);


--
-- TOC entry 2712 (class 2606 OID 16418)
-- Name: profile profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_pkey PRIMARY KEY (id);


--
-- TOC entry 2717 (class 2606 OID 16446)
-- Name: post post_post_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_post_id_fkey FOREIGN KEY (post_id) REFERENCES public.post(id);


--
-- TOC entry 2716 (class 2606 OID 16441)
-- Name: post post_profile_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.post
    ADD CONSTRAINT post_profile_id_fkey FOREIGN KEY (profile_id) REFERENCES public.profile(id);


--
-- TOC entry 2718 (class 2606 OID 16454)
-- Name: profile_2_subscriber profile_2_subscriber_profile_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_2_subscriber
    ADD CONSTRAINT profile_2_subscriber_profile_id_fkey FOREIGN KEY (profile_id) REFERENCES public.profile(id);


--
-- TOC entry 2719 (class 2606 OID 16459)
-- Name: profile_2_subscriber profile_2_subscriber_subscriber_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile_2_subscriber
    ADD CONSTRAINT profile_2_subscriber_subscriber_id_fkey FOREIGN KEY (subscriber_id) REFERENCES public.profile(id);


--
-- TOC entry 2715 (class 2606 OID 16419)
-- Name: profile profile_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.profile
    ADD CONSTRAINT profile_id_fkey FOREIGN KEY (id) REFERENCES public.account(id);


-- Completed on 2019-07-15 11:19:09

--
-- PostgreSQL database dump complete
--

