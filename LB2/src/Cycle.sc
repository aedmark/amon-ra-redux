;;; Sierra Script 1.0 - (do not remove this comment)
(script# 992)
(include sci.sh)
(use Main)
(use Obj)


(class Cycle of Obj
	(properties
		sel_20 {Cycle}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
	)
	
	(method (sel_110 theSel_42)
		(if argc (= sel_42 theSel_42))
		(= sel_158 (- (- gSel_45 (sel_42 sel_244?)) 1))
		(= sel_240 0)
	)
	
	(method (sel_241)
		(return
			(if
			(< (Abs (- gSel_45 sel_158)) (sel_42 sel_244?))
				(sel_42 sel_4?)
			else
				(= sel_158 gSel_45)
				(+ (sel_42 sel_4?) sel_239)
			)
		)
	)
	
	(method (sel_242)
	)
	
	(method (sel_243)
		(sel_42 sel_245: 0)
		(if (and sel_240 (IsObject sel_143))
			(sel_143 sel_145:)
		)
		(self sel_111:)
	)
)

(class Fwd of Cycle
	(properties
		sel_20 {Fwd}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
	)
	
	(method (sel_57 &tmp fwdSel_241)
		(if
		(> (= fwdSel_241 (self sel_241:)) (sel_42 sel_246:))
			(self sel_242:)
		else
			(sel_42 sel_4: fwdSel_241)
		)
	)
	
	(method (sel_242)
		(sel_42 sel_4: 0)
	)
)

(class Walk of Fwd
	(properties
		sel_20 {Walk}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
	)
	
	(method (sel_57 &tmp temp0)
		(if (not (sel_42 sel_247:)) (super sel_57:))
	)
)

(class CT of Cycle
	(properties
		sel_20 {CT}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_248 0
	)
	
	(method (sel_110 param1 param2 theSel_239 theSel_143 &tmp sel_42Sel_246)
		(super sel_110: param1)
		(= sel_239 theSel_239)
		(if (== argc 4) (= sel_143 theSel_143))
		(= sel_248
			(if (> param2 (= sel_42Sel_246 (sel_42 sel_246:)))
				sel_42Sel_246
			else
				param2
			)
		)
	)
	
	(method (sel_57 &tmp cTSel_241 sel_42Sel_246)
		(if
		(> sel_248 (= sel_42Sel_246 (sel_42 sel_246:)))
			(= sel_248 sel_42Sel_246)
		)
		(= cTSel_241 (self sel_241:))
		(sel_42
			sel_4:
				(cond 
					((> cTSel_241 sel_42Sel_246) 0)
					((< cTSel_241 0) sel_42Sel_246)
					(else cTSel_241)
				)
		)
		(if
		(and (== gSel_45 sel_158) (== sel_248 (sel_42 sel_4?)))
			(self sel_242:)
		)
	)
	
	(method (sel_242)
		(= sel_240 1)
		(if sel_143 (= global37 1) else (self sel_243:))
	)
)

(class End of CT
	(properties
		sel_20 {End}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_248 0
	)
	
	(method (sel_110 param1 param2)
		(super
			sel_110: param1 (param1 sel_246:) 1 (if (== argc 2) param2 else 0)
		)
	)
)

(class Beg of CT
	(properties
		sel_20 {Beg}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_248 0
	)
	
	(method (sel_110 param1 param2)
		(super
			sel_110: param1 0 -1 (if (== argc 2) param2 else 0)
		)
	)
)

(class SyncWalk of Fwd
	(properties
		sel_20 {SyncWalk}
		sel_42 0
		sel_143 0
		sel_239 1
		sel_158 0
		sel_240 0
		sel_249 0
		sel_250 0
	)
	
	(method (sel_57 &tmp sel_42Sel_56)
		(if
			(and
				(IsObject (= sel_42Sel_56 (sel_42 sel_56?)))
				(or
					(!= (sel_42 sel_1?) sel_249)
					(!= (sel_42 sel_0?) sel_250)
				)
			)
			(= sel_249 (sel_42 sel_1?))
			(= sel_250 (sel_42 sel_0?))
			(super sel_57:)
		)
	)
	
	(method (sel_241)
		(= sel_158 (+ gSel_45 (sel_42 sel_244?)))
		(super sel_241:)
	)
)

(class Motion of Obj
	(properties
		sel_20 {Motion}
		sel_42 0
		sel_143 0
		sel_1 0
		sel_0 0
		sel_43 0
		sel_44 0
		sel_45 0
		sel_46 0
		sel_47 0
		sel_48 0
		sel_49 0
		sel_50 0
		sel_240 0
		sel_249 0
		sel_250 0
	)
	
	(method (sel_110 theSel_42 theSel_1 theSel_0 theSel_143 &tmp [temp0 2] sel_42Sel_1 sel_42Sel_245)
		(if (>= argc 1)
			(= sel_42 theSel_42)
			(if (>= argc 2)
				(= sel_1 theSel_1)
				(if (>= argc 3)
					(= sel_0 theSel_0)
					(if (>= argc 4) (= sel_143 theSel_143))
				)
			)
		)
		(= sel_250 (= sel_249 (= sel_240 0)))
		(= sel_45 (+ 1 (sel_42 sel_53?) gSel_45))
		(if (= sel_42Sel_245 (sel_42 sel_245?))
			(sel_42Sel_245 sel_158: sel_45)
		)
		(if
			(GetDistance
				(= sel_42Sel_1 (sel_42 sel_1?))
				(= sel_42Sel_245 (sel_42 sel_0?))
				sel_1
				sel_0
			)
			(sel_42
				sel_253: (GetAngle sel_42Sel_1 sel_42Sel_245 sel_1 sel_0)
			)
		)
		(InitBresen self)
	)
	
	(method (sel_57 &tmp [temp0 6])
		(if
		(>= (Abs (- gSel_45 sel_45)) (sel_42 sel_53?))
			(= sel_45 gSel_45)
			(DoBresen self)
		)
	)
	
	(method (sel_97)
		(= sel_240 1)
		(if sel_143 (= global37 1) else (self sel_243:))
	)
	
	(method (sel_251 theSel_1 theSel_0)
		(if argc (= sel_1 theSel_1) (= sel_0 theSel_0))
	)
	
	(method (sel_252)
		(return
			(if (== (sel_42 sel_1?) sel_1)
				(== (sel_42 sel_0?) sel_0)
			else
				0
			)
		)
	)
	
	(method (sel_243)
		(sel_42 sel_56: 0)
		(if (and sel_240 (IsObject sel_143))
			(sel_143 sel_145:)
		)
		(self sel_111:)
	)
)

(class MoveTo of Motion
	(properties
		sel_20 {MoveTo}
		sel_42 0
		sel_143 0
		sel_1 0
		sel_0 0
		sel_43 0
		sel_44 0
		sel_45 0
		sel_46 0
		sel_47 0
		sel_48 0
		sel_49 0
		sel_50 0
		sel_240 0
		sel_249 0
		sel_250 0
	)
	
	(method (sel_110)
		(super sel_110: &rest)
	)
	
	(method (sel_252)
		(return
			(if
			(<= (Abs (- (sel_42 sel_1?) sel_1)) (sel_42 sel_51?))
				(<= (Abs (- (sel_42 sel_0?) sel_0)) (sel_42 sel_52?))
			else
				0
			)
		)
	)
)
